package io.github.epi155.recfm.api;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.File;


@Builder
@RequiredArgsConstructor
public class GenerateArgs {
    @NonNull public final File sourceDirectory;
    public final String group;
    public final String artifact;
    public final String version;
    @Builder.Default
    public final boolean doc = true;
}