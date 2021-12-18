package pairmatching.view;

import static pairmatching.utils.Message.*;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String function() {
        System.out.println(FUNCTION_SELECTION);
        return Console.readLine();
    }

    public static String matching() {
        System.out.println("\n" + MATCHING);
        return Console.readLine();
    }

    public static String rematching() {
        System.out.println("\n" + REMATCHING);
        return Console.readLine();
    }
}
