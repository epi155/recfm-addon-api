package io.github.epi155.recfm.util;

import java.util.concurrent.atomic.AtomicBoolean;

public interface ValidateField<T> {
    void validate(T fld, int padWidth, int bias, AtomicBoolean firstStatement);
}
