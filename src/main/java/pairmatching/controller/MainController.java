package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Init;
import pairmatching.domain.Level;
import pairmatching.domain.validation.Exception;
import pairmatching.domain.validation.Validator;
import pairmatching.view.InputView;
import pairmatching.view.MenuView;
import pairmatching.view.OutputView;

public class MainController {
    private final String PAIR_MATCHING = "1";
    private final String PAIR_CHECK = "2";
    private final String PAIR_RESET = "3";
    private final String END_MENU = "Q";
    private final Exception exception;
    private final Validator validator;
    private final Init init;
    private final ResetController resetController;
    private final MatchController matchController;
    private String menu = "";
    private String information = "";

    public MainController() throws IOException {
        this.exception = new Exception();
        this.validator = new Validator(exception);
        this.init = new Init();
        init.start();
        this.matchController = new MatchController(init);
        this.resetController = new ResetController(init);
    }

    public void start() {

        while (!menu.equals(END_MENU)) {
            chooseMenu();
            mappingMenu();
        }

    }

    private void chooseMenu() {

        try {
            OutputView.requestChooseMenu();
            MenuView.printMenu();
            menu = InputView.receiveInput();
            validator.isValidMenuChoice(menu);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(exception.getErrorMessage());
            chooseMenu();
        }

    }

    public void receiveInformation() {

        try {
            OutputView.printInformation(Level.values());
            OutputView.requestInformation();
            information = InputView.receiveInput();
            validator.isValidInformationInput(information, init.getMissionInformation());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(exception.getErrorMessage());
            receiveInformation();
        }

    }

    private void mappingMenu() {
        if (menu.equals(PAIR_MATCHING)) {
            receiveInformation();
            matchController.start(information);
            return;
        }

        if (menu.equals(PAIR_CHECK)) {
            receiveInformation();
            return;
        }

        if (menu.equals(PAIR_RESET)) {
            resetController.reset();
            return;
        }
    }
}
