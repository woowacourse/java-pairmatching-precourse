package pairmatching.controller;

import pairmatching.service.PairService;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.MatchingView;
import pairmatching.view.OutputView;

public class MatchingController {
    private static MatchingController instance;
    private static PairService pairService;

    public static MatchingController getInstance() {
        if (instance == null) {
            instance = new MatchingController();
            pairService = new PairService();

        }
        return instance;
    }

    public void run() {
        String input;
        do {
            MatchingView.printMatchingPrompt();
            input = inputMatchingCondition();
        } while (shouldRematch(input));
        pairService.createMatching(input);
    }

    private boolean shouldRematch(String input) {
        String answer = null;
        if (pairService.pairsExist(input)) {
            MatchingView.printShouldRematch();
            answer = InputView.getInput();
        }
        return false;
        //TODO: continue or not
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
