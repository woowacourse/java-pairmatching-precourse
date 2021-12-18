package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputAction() {
        String inputAction = Console.readLine();
        return inputAction;
    }

    public static String inputCourseLevelMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String input = Console.readLine();
        String course = input.split(",")[0];
        String level = input.split(",")[1];
        String mission = input.split(",")[2];
        return input;
    }
}
