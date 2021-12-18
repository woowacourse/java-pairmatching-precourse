package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Menu;
import pairmatching.model.Options;
import pairmatching.util.Message;

public class Input {
    private Input() {
    }

    public static Menu menu() {
        try {
            Output.guideMessage(Message.MENU_GUIDE);
            return Menu.parseMenu(Console.readLine());
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return menu();
        }
    }

    public static Options options() {
        try {
            Output.guideMessage(Message.COURSE_LEVEL_PROCESS);
            return new Options(Console.readLine());
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return options();
        }
    }
}
