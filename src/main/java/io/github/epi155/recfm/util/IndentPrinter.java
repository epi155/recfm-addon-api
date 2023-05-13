package io.github.epi155.recfm.util;

import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.IntFunction;

public class IndentPrinter extends AbstractPrinter {
    protected final IntFunction<String> pos;
    protected final Deque<String> indentStack = new LinkedList<>();

    protected IndentPrinter(PrintWriter pw) {
        super(pw);
        this.pos = String::valueOf;
    }

    protected IndentPrinter(PrintWriter pw, IntFunction<String> pos) {
        super(pw);
        this.pos = pos;
    }

    protected void pushIndent(int width) {
        String indent = CharBuffer.allocate(width).toString().replace('\0', ' ');
        indentStack.push(indent);
    }

    protected void popIndent() {
        indentStack.pop();
    }

    @Override
    public void printf(String format, Object... args) {
        if (!indentStack.isEmpty()) {
            write(indentStack.peek());
        }
        super.printf(format, args);
    }

}
