package io.github.epi155.recfm.api;

public interface OccTraitModel extends FieldModel {
    void setOffset(Integer offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setTypedef(TraitModel typedef);
    void setTimes(int times);
}
