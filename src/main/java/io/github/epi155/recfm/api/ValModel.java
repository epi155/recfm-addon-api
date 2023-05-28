package io.github.epi155.recfm.api;

public interface ValModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setAudit(boolean audit);
    void setValue(String value);
}
