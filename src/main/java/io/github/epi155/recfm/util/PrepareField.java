package io.github.epi155.recfm.util;

import org.jetbrains.annotations.NotNull;

public interface PrepareField<T> {
    void prepare(@NotNull T fld, int bias);
}
