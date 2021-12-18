package pairmatching.controller;

import pairmatching.service.PairService;
import pairmatching.view.MatchingView;
import pairmatching.view.OutputView;

public class ReferenceController {
    private static ReferenceController instance;
    private static PairService pairService;

    public static ReferenceController getInstance() {
        if (instance == null) {
            instance = new ReferenceController();
            pairService = PairService.getInstance();
        }
        return instance;
    }

    public void run() {
        try {
            String input;
            MatchingView.printMatchingPrompt();
            input = MatchingController.inputMatchingCondition();
            OutputView.printMatchingResult(pairService.getMatching(input));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }

}
