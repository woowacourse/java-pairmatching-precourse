package pairmatching.View;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Exception.NotValidMenuInputException;
import pairmatching.Menu;

public class InputView {
    private OutputView outputView;
    private final String CHOICE_YES="네";
    private final String CHOICE_NO="아니오";

    public String inputMenu(){
        String menu = "";
        try {
            menu = Console.readLine();
            if (!(menu.equals(Menu.PAIR_MATCHING_SEL) || menu.equals(Menu.PAIR_SEARCHING_SEL) ||menu.equals(Menu.PAIR_INITIALIZING_SEL) || menu.equals(Menu.QUIT_MENU_SEL))) {
                throw new NotValidMenuInputException();
            }
        } catch (NotValidMenuInputException e) {
            outputView.printErrorMessage(e);
            inputMenu();
        }
        return menu;
    }

    public String inputMission(){
        return Console.readLine();
    }
    
    public String inputRematching(){
        String isRematch = "";
        try {
            isRematch = Console.readLine();
            if (!(isRematch.equals(CHOICE_YES) || isRematch.equals(CHOICE_NO))) {
                throw new NotValidMenuInputException();
            }
        } catch (NotValidMenuInputException e) {
            outputView.printErrorMessage(e);
            inputRematching();
        }
        return isRematch;
    }
}
