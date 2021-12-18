package pairmatching.controller;

import pairmatching.domain.validation.Exception;
import pairmatching.domain.validation.Validator;
import pairmatching.view.InputView;
import pairmatching.view.MenuView;
import pairmatching.view.OutputView;


public class MainController {
    private final Exception exception;
    private final Validator validator;
    private final String END_MENU = "Q";
    private String menu = "";

    public MainController() {
        exception = new Exception();
        validator = new Validator(exception);
    }

    public void start() {

        while (!menu.equals(END_MENU)) {
            chooseMenu();
        }

    }

    private void chooseMenu() {

        try {
            MenuView.printMenu();
            menu = InputView.receiveInput();
            validator.isValidMenuChoice(menu);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(exception.getErrorMessage());
            chooseMenu();
        }

    }
}
