package io.github.epi155.recfm.api;

public interface AbcModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setRedefines(boolean redefines);
    void setAudit(boolean audit);
    void setOnOverflow(OverflowAction onOverflow);
    void setOnUnderflow(UnderflowAction onUnderflow);
    void setPadChar(char padChar);
    void setCheck(CheckChar check);
    void setNormalize(NormalizeAbcMode normalize);
}
