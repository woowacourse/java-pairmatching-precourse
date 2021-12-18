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
            pairService = PairService.getInstance();
        }
        return instance;
    }

    public void run() {
        String input;
        MatchingView.printMatchingPrompt();
        input = inputMatchingCondition();
        if (pairService.usedMatchInfo(input)) {
            MatchingView.printShouldRematch();
            String answer = InputView.getInput();
            if (!answer.equals("네")) {
                run();
                return;
            }
            pairService.deletePairs(input);
        }
        pairService.matchPairs(input);
        OutputView.printMatchingResult(pairService.getMatching(input));
    }

    public static String inputMatchingCondition() {
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
