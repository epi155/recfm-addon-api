package io.github.epi155.recfm.api;

public interface NumModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setRedefines(boolean redefines);
    void setAudit(boolean audit);
    void setOnOverflow(OverflowAction onOverflow);
    void setOnUnderflow(UnderflowAction onUnderflow);
    void setNumericAccess(boolean numericAccess);
    void setNormalize(NormalizeNumMode normalize);
}
