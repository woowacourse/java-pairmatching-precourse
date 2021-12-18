package pairmatching.controller;

import pairmatching.service.PairMatchingService;

import static pairmatching.utils.VerificationUtil.validateFunctionChoice;
import static pairmatching.view.OutputView.printFunctions;

public class PairMatchingController {

    private final PairMatchingService pairMatchingService = new PairMatchingService();

    public void runPairMatching() {
        while (true) {
            try {
                String input = printFunctions();

                validateFunctionChoice(input);

                choiceFunction(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
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
