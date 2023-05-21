package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class FieldEmbedGroup extends NakedField {
    private TraitDefine source;

    @Override
    protected FieldEmbedGroup shiftCopy(int plus) {
        throw new IllegalStateException();
    }
    protected Stream<NakedField> expand() {
        int targetOffset = getOffset();
        int sourceOffset = source.getFields().get(0).getOffset();
        return source.getFields().stream().peek(it -> it.setOffset(it.getOffset()-sourceOffset+targetOffset));
    }

}
