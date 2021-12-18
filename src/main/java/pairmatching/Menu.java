package pairmatching;

import pairmatching.Service.PairInitializing;
import pairmatching.Service.PairMatching;
import pairmatching.Service.PairSearching;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class Menu {
    public static final String PAIR_MATCHING_SEL = "1";
    public static final String PAIR_SEARCHING_SEL = "2";
    public static final String PAIR_INITIALIZING_SEL = "3";
    public static final String QUIT_MENU_SEL = "Q";
    private InputView inputView;
    private OutputView outputView = new OutputView();

    public Menu(InputView inputView) {
        this.inputView = inputView;
    }

    public void printMenu() {
        outputView.printMenu();
    }

    public String inputMenu() {
        return inputView.inputMenu();
    }

    public boolean runMenu() {
        printMenu();
        String selMenu = inputMenu();

        if (selMenu.equals(PAIR_MATCHING_SEL)) {
            PairMatching pairMatching = new PairMatching();
            pairMatching.run();
        }
        if (selMenu.equals(PAIR_SEARCHING_SEL)) {
            PairSearching pairSearching=new PairSearching();
            pairSearching.run();
        }
        if (selMenu.equals(PAIR_INITIALIZING_SEL)) {
            PairInitializing pairInitializing= new PairInitializing();
            pairInitializing.run();
        }
        if (selMenu.equals(QUIT_MENU_SEL)) {
            return false;
        }
        return true;
    }
}