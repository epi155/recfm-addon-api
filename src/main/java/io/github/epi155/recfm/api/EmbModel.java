package io.github.epi155.recfm.api;

public interface EmbModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setSource(TraitModel source);
}
