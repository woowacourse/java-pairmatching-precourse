package pairmatching.controller;

import pairmatching.service.MatchingService;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.MatchingView;
import pairmatching.view.OutputView;

public class MatchingController {
    private static MatchingController instance;
    private static MatchingService matchingService;

    public static MatchingController getInstance() {
        if (instance == null) {
            instance = new MatchingController();
            matchingService = new MatchingService();

        }
        return instance;
    }

    public void run() {
        MatchingView.printMatchingPrompt();
        String input = inputMatchingCondition();
        matchingService.createMatching(input);
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
