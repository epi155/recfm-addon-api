package io.github.epi155.recfm.type;

public enum NormalizeAbcMode {
    None, Trim, Trim1;
    public String of(AlignMode align) {
        if (this == None) return name();
        return align.code + name();
    }
}
