package io.github.epi155.recfm.api;

import java.util.List;

public interface TraitModel {
    String getName();
    void setName(String name);
    int getLength();
    void setLength(int length);
    List<FieldModel> getFields();
    void setFields(List<FieldModel> fields);

    void create(String namespace, GenerateArgs ga, FieldDefault defaults);
}
