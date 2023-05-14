package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Set;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class FieldOccursProxy extends FieldGroupProxy {
    private int times;

    @Override
    public void mark(boolean[] b, int bias) {
        for (int k = 0, shift = 0; k < times; k++, shift += getLength()) {
            int backShift = shift;
            getFields().forEach(it -> it.mark(b, bias - backShift));
        }
    }

    @Override
    public void mark(@SuppressWarnings("rawtypes") Set[] b, int bias) {
        if (isRedefines()) return;
        for (int k = 0, shift = 0; k < times; k++, shift += getLength()) {
            int backShift = shift;
            getFields().forEach(it -> it.mark(b, bias - backShift));
        }
    }

    @Override
    protected FieldOccursProxy shiftCopy(int plus) {
        val res = new FieldOccursProxy();
        res.times = this.times;
        res.setTypeDef(getTypeDef());
        res.setName(getName());
        res.setRedefines(isRedefines());
        res.setAudit(isAudit());
        res.setLength(getLength());
        res.setOffset(getOffset() + plus);
        return res;
    }

}
