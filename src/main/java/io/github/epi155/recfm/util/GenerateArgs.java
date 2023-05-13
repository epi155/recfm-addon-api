package io.github.epi155.recfm.util;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.io.File;


@Builder
@RequiredArgsConstructor
public class GenerateArgs {
    public final File sourceDirectory;
    public final String group;
    public final String artifact;
    public final String version;
    @Builder.Default
    public final int align = 4;
    @Builder.Default
    public final boolean doc = false;
    @Builder.Default
    public final boolean getCheck = true;
    @Builder.Default
    public final boolean setCheck = true;
}
