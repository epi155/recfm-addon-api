package io.github.epi155.recfm.api;

public interface CusModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setOnOverflow(OverflowAction onOverflow);
    void setOnUnderflow(UnderflowAction onUnderflow);
    void setPadChar(Character padChar);
    void setInitChar(Character initChar);
    void setCheck(CheckCus check);
    void setAlign(AlignMode align);
    void setNormalize(NormalizeAbcMode normalize);
    void setRegex(String regex);
    void setCheckGetter(Boolean checkGetter);
    void setCheckSetter(Boolean checkSetter);
}
