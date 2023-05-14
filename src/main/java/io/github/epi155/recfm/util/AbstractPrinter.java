package io.github.epi155.recfm.util;

import lombok.AllArgsConstructor;

import java.io.PrintWriter;

@AllArgsConstructor @Deprecated
public abstract class AbstractPrinter {
    private final PrintWriter pw;

    public void printf(String format, Object... args) {
        pw.printf(format, args);
    }

    protected void write(String s) {
        pw.write(s);
    }
}
