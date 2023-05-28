package io.github.epi155.recfm.api;

import lombok.Data;

@Data
public class FieldDefault {
    private AbcDefault abc = new AbcDefault();
    private NumDefault num = new NumDefault();
    private NuxDefault nux = new NuxDefault();
    private FilDefault fil = new FilDefault();
    private CusDefault cus = new CusDefault();

    @Data
    public static class AbcDefault {
        private CheckChar check = CheckChar.Ascii;
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeAbcMode normalize = NormalizeAbcMode.None;
    }

    @Data
    public static class FilDefault {
        private char fill = 0;
        private CheckChar check = CheckChar.None;
    }

    @Data
    public static class CusDefault {
        private char pad = ' ';
        private char init = ' ';
        private CheckUser check = CheckUser.Ascii;
        private AlignMode align = AlignMode.LFT;
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeAbcMode normalize = NormalizeAbcMode.None;
    }

    @Data
    public static class NumDefault {
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeNumMode normalize = NormalizeNumMode.None;
    }
    @Data
    public static class NuxDefault {
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeNumMode normalize = NormalizeNumMode.None;
        private InitializeNuxMode initialize = InitializeNuxMode.Spaces;
    }
}
