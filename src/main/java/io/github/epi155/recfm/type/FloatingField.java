package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class FloatingField extends SettableField {
    private OverflowAction onOverflow;
    private UnderflowAction onUnderflow;

    public abstract AlignMode getAlign();

    @NotNull public OverflowAction safeOverflow() {
        return onOverflow==null ? OverflowAction.Trunc : onOverflow;
    }
    @NotNull public UnderflowAction safeUnderflow() {
        return onUnderflow==null ? UnderflowAction.Pad : onUnderflow;
    }
}
