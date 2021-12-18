package pairmatching.view;

import pairmatching.constant.SystemMessage;
import pairmatching.domain.enums.MainMenuOption;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String mainMenu() {
        System.out.println(MainMenuOption.SELECT_MENU.print());
        System.out.println(MainMenuOption.PAIR_MATCHING.print());
        System.out.println(MainMenuOption.LOOKUP_PAIR.print());
        System.out.println(MainMenuOption.PAIR_INITIALIZE.print());
        System.out.println(MainMenuOption.QUIT.print());
        return Console.readLine();
    }

    public static String selectMission() {
        System.out.println(SystemMessage.printGetCourseMessage.print());
        return Console.readLine();
    }
}
