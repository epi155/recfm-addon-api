package io.github.epi155.recfm.api;

import java.util.List;

public interface ClassModel {
    String getName();
    void setName(String name);
    int getLength();
    void setLength(int length);
    void setOnOverflow(LoadOverflowAction onOverflow);
    void setOnUnderflow(LoadUnderflowAction onUnderflow);
    void setFields(List<FieldModel> fields);

    void create(String namespace, GenerateArgs ga, FieldDefault defaults);

}
