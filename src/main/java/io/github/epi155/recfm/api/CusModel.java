package io.github.epi155.recfm.api;

public interface CusModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setRedefines(boolean redefines);
    void setAudit(boolean audit);
    void setOnOverflow(OverflowAction onOverflow);
    void setOnUnderflow(UnderflowAction onUnderflow);
    void setPadChar(Character padChar);
    void setInitChar(Character character);
    void setCheck(CheckUser check);
    void setAlign(AlignMode align);
    void setNormalize(NormalizeAbcMode normalize);
    void setRegex(String regex);
}
