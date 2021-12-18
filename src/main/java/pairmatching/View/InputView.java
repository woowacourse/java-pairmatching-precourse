package pairmatching.View;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Exception.NotValidMenuInputException;
import pairmatching.Menu;

public class InputView {
    private OutputView outputView;

    public String inputMenu(){
        String menu = "";
        try {
            menu = Console.readLine();
            if (!(menu.equals(Menu.PAIR_MATCHING_SEL) || menu.equals(Menu.PAIR_SEARCHING_SEL) ||menu.equals(Menu.PAIR_INITIALIZING_SEL) || menu.equals(Menu.QUIT_MENU_SEL))) {
                throw new NotValidMenuInputException();
            }
        } catch (NotValidMenuInputException e) {
            outputView.printErrorMessage(e);
        }
        return menu;
    }
}
