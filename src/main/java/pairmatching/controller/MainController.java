package pairmatching.controller;

import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
    public static MainController instance;

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void run() {
        initMain();
    }

    private void initMain() {
        InputView.printSelectMode();
        String mode = mainScreenInput();
    }

    private String mainScreenInput() {
        try {
            String input = InputView.getInput();
            InputValidator.validateMainScreenInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return mainScreenInput();
        }
    }
}
