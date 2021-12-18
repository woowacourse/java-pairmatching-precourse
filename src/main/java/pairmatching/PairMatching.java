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
        return input.equals(GeneralInputView.QUIT);
    }

    public boolean selectFunctionByInput(String input) {
        if (quit(input)) {
            return false;
        }
        if (input.equals(GeneralInputView.START_MATCH)) {
            matchingController.startMatching(matchingController.inputCourseByUser());
        }
        if (input.equals(GeneralInputView.SEE_MATCH)) {
            matchingController.seeMatchingInfo(matchingController.inputCourseByUser());
        }
        if (input.equals(GeneralInputView.INIT_MATCH)) {
            matchingController.resetMatching();
        }
        return true;
    }
}
