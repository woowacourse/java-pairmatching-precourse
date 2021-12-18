package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Level;

import static pairmatching.constants.FormatConstants.*;
import static pairmatching.constants.InputMessages.*;

public class InputView {

    public static String requestMainMenuInput() {
        System.out.println(REQUEST_MAIN_MENU_INPUT);
        return Console.readLine();
    }

    public static void showBackgroundInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(DIVIDER);
        sb.append(COURSES);
        sb.append(MISSION);
        for (Level level : Level.values()) {
            sb.append(MISSION_FORMAT(level));
        }
        sb.append(DIVIDER);
        System.out.println(sb);
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
