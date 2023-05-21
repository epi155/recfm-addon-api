package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class FieldGroupTrait extends NamedField implements ParentFields {
    private TraitDefine typeDef;

    @Override
    public List<NakedField> getFields() {
        val fields = typeDef.getFields();
        int base = fields.get(0).getOffset();
        val plus = getOffset() - base;
        return fields.stream().flatMap(NakedField::expand)
            .map(fld -> fld.shiftCopy(plus)).collect(Collectors.toList());
    }

    @Override
    public boolean noHole() {
        return noHole(getOffset());
    }

    @Override
    public boolean noOverlap() {
        return noOverlap(getOffset());
    }

    @Override
    protected FieldGroupTrait shiftCopy(int plus) {
        val res = new FieldGroupTrait();
        res.typeDef = this.typeDef;
        res.setName(getName());
        res.setRedefines(isRedefines());
        res.setAudit(isAudit());
        res.setLength(getLength());
        res.setOffset(getOffset() + plus);
        return res;
    }
}
