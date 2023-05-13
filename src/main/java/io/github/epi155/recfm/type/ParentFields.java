package io.github.epi155.recfm.type;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.event.Level;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public interface ParentFields /*extends IndentAble*/ {
    org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ParentFields.class);

    String getName();

    List<NakedField> getFields();

    int getLength();

    default int evalPadWidth(int min) {
        NuclearInt wid = new NuclearInt(min);
        getFields().forEach(it -> {
            if (it instanceof FloatingField) {
                FloatingField fld = (FloatingField) it;
                wid.maxOf(fld.getName().length());
            } else if (it instanceof ParentFields) {
                wid.maxOf(((ParentFields) it).evalPadWidth(wid.get()));
            }
        });
        return wid.get();
    }

    default boolean noHole(int bias) {
        log.info("  [##o..] Checking for hole in group {}: [{}..{}] ...", getName(), bias, bias + getLength() - 1);
        boolean[] b = new boolean[getLength()];
        getFields().forEach(it -> it.mark(b, bias));
        List<Integer> hole = new ArrayList<>();
        for (int k = 0; k < getLength(); k++) {
            if (!b[k]) hole.add(k);
        }
        if (hole.isEmpty()) {
            return noHoleChilds();
        } else {
            DisplayHoles dis = new DisplayHoles();
            hole.forEach(dis::add);
            dis.close();
            return false;
        }
    }

    default boolean noHoleChilds() {
        AtomicInteger nmFail = new AtomicInteger(0);
        getFields().forEach(it -> {
            if (it instanceof ParentFields) {
                ParentFields par = (ParentFields) it;
                if (!par.noHole()) nmFail.incrementAndGet();
            }
        });
        if (nmFail.get() == 0) {
            log.info("  [###..] No hole detected in {}.", getName());
            return true;
        } else {
            log.info("  [!!!..] Hole detected in sub-group.");
            return false;
        }
    }

    default boolean noOverlap(int bias) {
        log.info("  [###o.] Checking for overlap in group {}: [{}..{}] ...", getName(), bias, bias + getLength() - 1);
        @SuppressWarnings("unchecked") Set<String>[] b = new Set[getLength()];
        getFields().forEach(it -> it.mark(b, bias));
        List<Pair<Integer, Set<String>>> over = new ArrayList<>();
        for (int k = 0; k < getLength(); k++) {
            if (b[k] != null && b[k].size() > 1) over.add(new ImmutablePair<>(k + bias, b[k]));
        }
        if (over.isEmpty()) {
            return noOverlapChilds();
        } else {
            DisplayOver dis = new DisplayOver();
            over.forEach(dis::add);
            dis.close();
            return false;
        }
    }

    default boolean noOverlapChilds() {
        AtomicInteger nmFail = new AtomicInteger(0);
        getFields().forEach(it -> {
            if (it instanceof ParentFields) {
                ParentFields par = (ParentFields) it;
                if (!par.noOverlap()) nmFail.incrementAndGet();
            }
        });
        if (nmFail.get() == 0) {
            log.info("  [####.] No overlap detected in {}.", getName());
            return true;
        } else {
            log.info("  [!!!!.] Overlap detected in sub-group.");
            return false;
        }
    }

    default boolean noDuplicateName(NameCollisionProbe probe) {
        log.info("  [#o...] Checking for duplicate in group {} ...", getName());
        Map<String, NamedField> map = new HashMap<>();
        AtomicInteger countDup = new AtomicInteger();
        getFields().forEach(it -> scanNamedField(it, map, countDup, probe));
        if (countDup.get() == 0) {
            getFields().forEach(it -> scanParentFieldsDup(it, countDup, probe));
            if (countDup.get() == 0) {
                log.info("  [##...] No duplicate fieldName detected in {}.", getName());
                return true;
            } else {
                log.info("  [!!...] Duplicate fieldName detected in sub-group.");
                return false;
            }
        } else {
            log.info("  [!!...] {} duplicate fieldName detected.", countDup.get());
            return false;
        }
    }
    default void checkForVoid() {
        long voidFields = getFields().stream().filter(Objects::isNull).count();
        if (voidFields > 0) {
            log.error("{} void field definitions", voidFields);
            throw new ClassDefineException("Class <" + getName() + "> bad defined");
        }
    }

    default boolean noBadName() {
        log.info("  [o....] Checking for bad name in group {} ...", getName());
        AtomicInteger countBad = new AtomicInteger();
        getFields().forEach(it -> scanBadName(it, countBad));
        if (countBad.get() == 0) {
            getFields().forEach(it -> scanParentFieldsBad(it, countBad));
            if (countBad.get() == 0) {
                log.info("  [#....] No bad fieldName detected in {}.", getName());
                return true;
            } else {
                log.info("  [!....] Bad fieldName detected in sub-group.");
                return false;
            }
        } else {
            log.info("  [!....] {} bad fieldName detected.", countBad.get());
            return false;
        }
    }

    default void scanParentFieldsBad(NakedField it, AtomicInteger countBad) {
        if (it instanceof ParentFields) {
            ParentFields par = (ParentFields) it;
            if (!par.noBadName()) countBad.getAndIncrement();
        }
    }

    default void scanParentFieldsDup(NakedField it, AtomicInteger dup, NameCollisionProbe deepCheck) {
        if (it instanceof ParentFields) {
            ParentFields par = (ParentFields) it;
            if (!par.noDuplicateName(deepCheck)) dup.getAndIncrement();
        }
    }

    default void scanNamedField(NakedField it, Map<String, NamedField> map, AtomicInteger dup, NameCollisionProbe probe) {
        if (it instanceof NamedField) {
            NamedField fld = (NamedField) it;
            NamedField old = map.put(fld.getName(), fld);
            if (old != null) {
                if (fld instanceof FieldGroup) {
                    if (old instanceof FieldGroup) {
                        // GG
                        log.error("  [#X...] GroupName '{}' duplicate @{}+{} and @{}+{} XXX", fld.getName(),
                            old.getOffset(), old.getLength(), it.getOffset(), it.getLength());
                        dup.getAndIncrement();
                    } else {
                        // fld-G x old-F
                        if (probe.collisionLevel(old, (FieldGroup) fld) == Level.ERROR)
                            dup.getAndIncrement();
                    }
                } else {
                    if (old instanceof FieldGroup) {
                        // fld-F x old-G
                        if (probe.collisionLevel(fld, (FieldGroup) old) == Level.ERROR)
                            dup.getAndIncrement();
                    } else {
                        // fld-F x old-F
                        log.error("  [#X...] FieldName '{}' duplicate @{}+{} and @{}+{} XXX", fld.getName(),
                            old.getOffset(), old.getLength(), it.getOffset(), it.getLength());
                        dup.getAndIncrement();
                    }
                }
            }
        }
    }

    default void scanBadName(NakedField it, AtomicInteger dup) {
        if (it instanceof NamedField) {
            NamedField kt = (NamedField) it;
            if (!kt.getName().matches("[a-zA-Z_][a-zA-Z_0-9$]*")) {
                log.error("  [X....]  FieldName '{}' not valid @{}+{} XXX", kt.getName(), it.getOffset(), it.getLength());
                dup.getAndIncrement();
            }
        }
    }

    default boolean noOverlap() {
        return noOverlap(1);
    }

    default boolean noHole() {
        return noHole(1);
    }
}
