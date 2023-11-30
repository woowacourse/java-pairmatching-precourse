package pairmatching.controller;

import static pairmatching.view.ouput.OutputView.responseResetOfMatching;

import pairmatching.domain.MatchingHistory;

public class PairResetController {
    private PairResetController(){}

    public static void pairReset() {
        MatchingHistory matchingHistory = MatchingHistory.of();
        matchingHistory.deleteAllMatchingResult();
        responseResetOfMatching();
    }
}
