package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputAction() {
        String inputAction = Console.readLine();
        return inputAction;
    }

    public static String inputCourseLevelMission() {
        String input = Console.readLine();
        String course = input.split(",")[0];
        String level = input.split(",")[1];
        String mission = input.split(",")[2];
        return input;
    }
}
