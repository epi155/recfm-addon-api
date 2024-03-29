package io.github.epi155.recfm.api;

public interface AbcModel extends FieldModel {
    void setOffset(Integer offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setOnOverflow(OverflowAction onOverflow);
    void setOnUnderflow(UnderflowAction onUnderflow);
    void setCheck(CheckAbc check);
    void setNormalize(NormalizeAbcMode normalize);
    void setCheckGetter(Boolean checkGetter);
    void setCheckSetter(Boolean checkSetter);
}
