package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class FieldCustom extends FloatingField implements SelfCheck {
    private Character padChar;
    private Character initChar;
    private CheckUser check;
    private AlignMode align;
    private String regex;

    @Override
    public String picture() {
        return "C";
    }

    @Override
    public void selfCheck() {
        if (regex != null) {
            try {
                Pattern.compile(regex);
            } catch (PatternSyntaxException e) {
                throw new ClassDefineException(fieldDescriptor() + " invalid regex: " + e.getMessage());
            }
        }
    }

    private String fieldDescriptor() {
        return "Field " + getName() + "@" + getOffset() + "+" + getLength();
    }
}
