package io.github.epi155.recfm.api;

public interface DomModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setAudit(boolean audit);
    void setItems(String[] items);
}
