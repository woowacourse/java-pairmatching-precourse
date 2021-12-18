package pairmatching;

import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class Menu{
    public static final String PAIR_MATCHING_SEL = "1";
    public static final String PAIR_SEARCHING_SEL = "2";
    public static final String PAIR_INITIALIZING_SEL = "3";
    public static final String QUIT_MENU_SEL = "Q";
    private InputView inputView;
    private OutputView outputView=new OutputView();

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
            System.out.println("1");
        }
        if (selMenu.equals(PAIR_SEARCHING_SEL)) {
            System.out.println("2");
        }
        if (selMenu.equals(PAIR_INITIALIZING_SEL)) {
            System.out.println("3");
        }
        if (selMenu.equals(QUIT_MENU_SEL)) {
            return false;
        }
        return true;
    }
}