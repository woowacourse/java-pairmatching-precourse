package pairmatching.controller;

import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
    private static final String MATCHING_MODE = "1";
    private static final String REFERENCE_MODE = "2";
    private static final String CLEAR_MODE = "3";
    private static final String EXIT_MODE = "Q";
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
        String mode;
        do {
            InputView.printSelectMode();
            mode = mainScreenInput();
        } while(moveController(mode));
    }

    private boolean moveController(String mode) {
        if (mode.equals(MATCHING_MODE)) {
            System.out.println("1");
        }
        if (mode.equals(REFERENCE_MODE)) {
            System.out.println("2");
        }
        if (mode.equals(CLEAR_MODE)) {
            System.out.println("3");
        }
        return !mode.equals(EXIT_MODE);
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
