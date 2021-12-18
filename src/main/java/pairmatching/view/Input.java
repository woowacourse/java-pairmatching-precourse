package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Menu;
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
}
