package io.github.epi155.recfm.api;

public interface GrpTraitModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setTypedef(TraitModel typedef);
}
