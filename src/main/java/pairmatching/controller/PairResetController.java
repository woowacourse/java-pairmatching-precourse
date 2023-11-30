package pairmatching.controller;

import pairmatching.domain.MatchingHistory;

public class PairResetController {
    MatchingHistory matchingHistory = MatchingHistory.of();
    private PairResetController(){}

    public static void pairReset() {
        MatchingHistory matchingHistory = MatchingHistory.of();
        matchingHistory.deleteAllMatchingResult();
    }
}
