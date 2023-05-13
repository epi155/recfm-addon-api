package io.github.epi155.recfm.type;

import lombok.Data;

@Data
public class Defaults {
    private AbcDefault abc = new AbcDefault();
    private FilDefault fil = new FilDefault();
    private CusDefault cus = new CusDefault();

    @Data
    public static class AbcDefault {
        private CheckChar check = CheckChar.Ascii;
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

    }
}
