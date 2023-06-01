package io.github.epi155.recfm.api;

public interface NumModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setAudit(boolean audit);
    void setOnOverflow(OverflowAction onOverflow);
    void setOnUnderflow(UnderflowAction onUnderflow);
    void setAccess(AccesMode mode);
    void setWordWidth(WordWidth width);
    void setNormalize(NormalizeNumMode normalize);
}
