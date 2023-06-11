package io.github.epi155.recfm.api;

public interface ValModel extends FieldModel {
    void setOffset(Integer offset);
    void setLength(int length);
    void setValue(String value);
}
