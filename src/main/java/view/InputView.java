package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readSelect() {
        String selectNumber = Console.readLine();
        return selectNumber;
    }
    public String readSelectCourseAndMission() {
        String selectCourAndMis = Console.readLine();
        return selectCourAndMis;
    }
}
