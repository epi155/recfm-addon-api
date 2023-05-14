package io.github.epi155.recfm.api;

import io.github.epi155.recfm.type.ClassDefine;
import io.github.epi155.recfm.type.Defaults;
import io.github.epi155.recfm.util.GenerateArgs;

import java.io.File;

public interface CodeProvider {
    void createInterface(File sourceRootDirectory, String wrtPackage, ClassDefine struct, GenerateArgs ga);
    void createClass(File sourceRootDirectory, String wrtPackage, ClassDefine struct, GenerateArgs ga, Defaults defaults);
}
