package pairmatching.controller;

import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.MatchingView;
import pairmatching.view.OutputView;

public class MatchingController {
    private static MatchingController instance;

    public static MatchingController getInstance() {
        if (instance == null) {
            instance = new MatchingController();

        }
        return instance;
    }

    public void run() {
        MatchingView.printMatchingPrompt();
        String input = inputMatchingCondition();
    }

    private String inputMatchingCondition() {
        try {
            MatchingView.printSelectPrompt();
            String input = InputView.getInput();
            InputValidator.validateMatchingInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputMatchingCondition();
        }
    }
}
