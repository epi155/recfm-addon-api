package io.github.epi155.recfm.api;

public interface OccTraitModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setRedefines(boolean redefines);
    void setTypedef(TraitModel typedef);
    void setTimes(int times);
}
