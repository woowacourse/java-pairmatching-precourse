package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.PrintStream;

public class InputView {

    private static final PrintStream printStream = System.out;

    public static String getLineWithPrompt(String prompt) {
        printStream.println(prompt);
        return Console.readLine();
    }
}
