package io.github.epi155.recfm.api;

import io.github.epi155.recfm.type.ClassDefine;
import io.github.epi155.recfm.type.Defaults;
import io.github.epi155.recfm.type.TraitDefine;
import io.github.epi155.recfm.util.GenerateArgs;

public interface CodeProvider {
    void createInterface(String namespace, TraitDefine struct, GenerateArgs ga);
    void createClass(String namespace, ClassDefine struct, GenerateArgs ga, Defaults defaults);
}
