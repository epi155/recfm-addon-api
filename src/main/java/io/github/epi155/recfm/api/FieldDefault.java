package io.github.epi155.recfm.api;

import lombok.Data;

@Data
public class FieldDefault {
    private ClsDefault cls = new ClsDefault();
    private AbcDefault abc = new AbcDefault();
    private NumDefault num = new NumDefault();
    private NuxDefault nux = new NuxDefault();
    private FilDefault fil = new FilDefault();
    private CusDefault cus = new CusDefault();

    @Data
    public static class ClsDefault {
        private LoadOverflowAction onOverflow = LoadOverflowAction.Trunc;
        private LoadUnderflowAction onUnderflow = LoadUnderflowAction.Pad;
        private boolean doc = true;
    }
    @Data
    public static class AbcDefault {
        private CheckAbc check = CheckAbc.Ascii;
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeAbcMode normalize = NormalizeAbcMode.None;
        private boolean checkGetter = true;
        private boolean checkSetter = true;
    }

    @Data
    public static class FilDefault {
        private char fill = 0;
    }

    @Data
    public static class CusDefault {
        private char padChar = ' ';
        private char initChar = ' ';
        private CheckCus check = CheckCus.Ascii;
        private AlignMode align = AlignMode.LFT;
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeAbcMode normalize = NormalizeAbcMode.None;
        private boolean checkGetter = true;
        private boolean checkSetter = true;
    }

    @Data
    public static class NumDefault {
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeNumMode normalize = NormalizeNumMode.None;
        private WordWidth wordWidth = WordWidth.Int;
        private AccesMode access = AccesMode.String;
    }
    @Data
    public static class NuxDefault {
        private OverflowAction onOverflow = OverflowAction.Trunc;
        private UnderflowAction onUnderflow = UnderflowAction.Pad;
        private NormalizeNumMode normalize = NormalizeNumMode.None;
        private InitializeNuxMode initialize = InitializeNuxMode.Spaces;
        private WordWidth wordWidth = WordWidth.Int;
        private AccesMode access = AccesMode.String;
    }
}
