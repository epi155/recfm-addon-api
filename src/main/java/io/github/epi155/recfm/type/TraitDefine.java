package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class TraitDefine implements ParentFields {
    private String name;
    private int length;
    private List<NakedField> fields = new ArrayList<>();
}
