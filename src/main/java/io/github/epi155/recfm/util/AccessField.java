package io.github.epi155.recfm.util;

@Deprecated
public interface AccessField<T> {
    void access(T fld, String wrkName, int indent, GenerateArgs ga);
}
