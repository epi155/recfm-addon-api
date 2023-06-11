package io.github.epi155.recfm.api;

import java.util.List;

public interface OccModel extends  FieldModel {
    void setOffset(Integer offset);
    void setLength(int length);
    void setName(String name);
    void setOverride(boolean override);
    void setFields(List<FieldModel> fields);
    void setTimes(int times);
}
