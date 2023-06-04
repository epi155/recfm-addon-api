package io.github.epi155.recfm.api;

public interface NuxModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setOnOverflow(OverflowAction onOverflow);
    void setOnUnderflow(UnderflowAction onUnderflow);
    void setAccess(AccesMode access);
    void setWordWidth(WordWidth wordWidth);
    void setNormalize(NormalizeNumMode normalize);
    void setInitialize(InitializeNuxMode initialize);
}
