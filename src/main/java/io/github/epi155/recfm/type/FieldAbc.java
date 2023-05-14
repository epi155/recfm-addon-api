package io.github.epi155.recfm.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.val;

@Data
@EqualsAndHashCode(callSuper = true)
public class FieldAbc extends FloatingField /*implements IndentAble*/ {
    private char padChar = ' ';
    private CheckChar check;
    private NormalizeAbcMode normalize;

    @Override
    public AlignMode getAlign() {
        return AlignMode.LFT;
    }

    @Override
    public String picture() {
        return "A";
    }

    @Override
    protected FieldAbc shiftCopy(int plus) {
        val res = new FieldAbc();
        res.check = this.check;
        res.padChar = this.padChar;
        res.normalize = this.normalize;
        res.setOnOverflow(getOnOverflow());
        res.setOnUnderflow(getOnUnderflow());
        res.setName(getName());
        res.setRedefines(isRedefines());
        res.setAudit(isAudit());
        res.setLength(getLength());
        res.setOffset(getOffset() + plus);
        return res;
    }
}
