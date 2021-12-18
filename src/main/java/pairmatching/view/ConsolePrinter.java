package pairmatching.view;

import java.io.PrintStream;

public class ConsolePrinter {

    private static final PrintStream printStream = System.out;

    public static void print(String line) {
        printStream.println(line);
    }
}
