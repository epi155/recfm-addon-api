package io.github.epi155.recfm.util;

import org.jetbrains.annotations.NotNull;

public interface InitializeField<T> {
    void initialize(@NotNull T fld, int bias);
}
