package io.github.epi155.recfm.type;

public enum OverflowAction {
    Error, Trunc;

    @Deprecated
    public String of(AlignMode align) {
        if (this == Error) return name();
        return name() + align.code;
    }
}
