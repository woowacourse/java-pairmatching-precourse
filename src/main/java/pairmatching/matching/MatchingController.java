package pairmatching.matching;

import pairmatching.GeneralInputView;
import pairmatching.GeneralOutputView;

public class MatchingController {
    private final MatchingService matchingService;

    public MatchingController() {
        matchingService = new MatchingService();
    }

    public String inputFunctionByUser() {
        String choice;
        try {
            String input = GeneralInputView.inputFunctionByClient();
            // 검증로직
            choice = input;

        } catch (IllegalArgumentException e) {
            choice = inputFunctionByUser();
        }
        return choice;
    }

}
