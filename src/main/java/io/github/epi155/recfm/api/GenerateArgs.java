package io.github.epi155.recfm.api;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.File;


@Builder
public class GenerateArgs {
    @NonNull public final String sourceDirectory;
    public final String group;
    public final String artifact;
    public final String version;
}
