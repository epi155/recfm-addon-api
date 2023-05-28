package io.github.epi155.recfm.api;

import java.util.List;

public interface GrpModel extends FieldModel {
    void setOffset(int offset);
    void setLength(int length);
    void setName(String name);
    void setRedefines(boolean redefines);
    void setFields(List<FieldModel> fields);
}
