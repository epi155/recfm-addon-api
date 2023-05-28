package io.github.epi155.recfm.api;

public interface FilModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setFillChar(Character fillChar);
    void setCheck(CheckChar check);
}
