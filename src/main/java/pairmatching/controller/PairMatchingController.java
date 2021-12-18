package pairmatching.controller;

import pairmatching.service.PairMatchingService;

import static pairmatching.view.OutputView.printFunctions;

public class PairMatchingController {

    private final PairMatchingService pairMatchingService = new PairMatchingService();

    public void runPairMatching() {
        while (true) {
            String input = printFunctions();
            choiceFunction(input);
        }
    }

    private void choiceFunction(String input) {
        if (input.equals("1")) {
            pairMatchingService.pairMatching();
        }

        if (input.equals("2")) {
            pairMatchingService.inquiryPair();
        }

        if (input.equals("3")) {
            pairMatchingService.initPair();
        }

        if (input.equals("Q")) {
            System.exit(0);
        }
    }
}
