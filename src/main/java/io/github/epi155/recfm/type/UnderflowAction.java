package io.github.epi155.recfm.type;

public enum UnderflowAction {
    Error, Pad;

    public String of(AlignMode align) {
        if (this == Error) return name();
        return name() + align.code;
    }
}
