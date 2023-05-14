package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class FieldConstant extends NakedField implements SelfCheck, CheckAware {
    private String value;
    private boolean audit;

    @Override
    protected FieldConstant shiftCopy(int plus) {
        val res = new FieldConstant();
        res.value = this.value;
        res.audit = this.audit;
        res.setLength(getLength());
        res.setOffset(getOffset() + plus);
        return res;
    }

    @Override
    public void selfCheck() {
        if (value == null) {
            log.error("Field @{}+{} without required <value>", getOffset(), getLength());
            throw new ClassDefineException("Field @" + getOffset() + "+" + getLength() + " required <value>");
        }
        if (value.length() != getLength()) {
            log.error("Mismatch value length");
            throw new ClassDefineException("Mismatch value length @" + getOffset() + "+" + getLength());
        }
    }

}
