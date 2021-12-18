package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.MenuView;
import pairmatching.view.OutputView;

public class MainController {
    private String END_MENU = "Q";
    private String menu = "";

    public void start() {

        while (!menu.equals(END_MENU)) {
            chooseMenu();
        }

    }

    private void chooseMenu() {

        try {
            MenuView.printMenu();
            menu = InputView.receiveInput();
        } catch (IllegalArgumentException e) {

        }

    }
}
