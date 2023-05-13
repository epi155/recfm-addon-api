package io.github.epi155.recfm.api;

import io.github.epi155.recfm.type.ClassDefine;
import io.github.epi155.recfm.type.Defaults;
import io.github.epi155.recfm.util.GenerateArgs;

import java.io.File;
import java.io.PrintWriter;

public interface CodeProvider {
    File fileOf(String cwd, String name);
    void createClass(PrintWriter pw, String wrtPackage, ClassDefine struct, GenerateArgs ga, Defaults defaults);
}
