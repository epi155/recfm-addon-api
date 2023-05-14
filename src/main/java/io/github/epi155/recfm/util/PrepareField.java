package io.github.epi155.recfm.util;

import org.jetbrains.annotations.NotNull;

@Deprecated
public interface PrepareField<T> {
    void prepare(@NotNull T fld, int bias);
}
