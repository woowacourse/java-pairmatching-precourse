package pairmatching;

import pairmatching.matching.MatchingController;

public class PairMatching {
    private final MatchingController matchingController;

    public PairMatching() {
        matchingController = new MatchingController();
    }

    public boolean run() {
        return selectFunctionByInput(matchingController.inputFunctionByUser());
    }

    public boolean quit(String input) {
        return input.equals("Q");
    }

    public boolean selectFunctionByInput(String input) {
        if (quit(input)) {
            return false;
        }
        if (input.equals("1")) {
            matchingController.startMatching();
        }
        if (input.equals("2")) {
            matchingController.seeMatchingInfo();
        }
        if (input.equals("3")) {
            matchingController.resetMatching();
        }
        return true;
    }
}
