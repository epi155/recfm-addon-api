package io.github.epi155.recfm.api;

public interface DomModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setRedefines(boolean redefines);
    void setAudit(boolean audit);
    void setItems(String[] items);
}
