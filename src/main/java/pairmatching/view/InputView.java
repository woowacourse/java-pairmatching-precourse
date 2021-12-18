package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import static pairmatching.constants.InputMessages.*;

public class InputView {

    public static String requestMainMenuInput() {
        System.out.println(REQUEST_MAIN_MENU_INPUT);
        return Console.readLine();
    }

    public static String requestPairMatchingOptionsInput() {
        System.out.println(REQUEST_PAIR_MATCHING_OPTIONS_INPUT);
        return Console.readLine();
    }

    public static String requestNewMatchInput() {
        System.out.println(REQUEST_NEW_MATCH_INPUT);
        return Console.readLine();
    }
}
