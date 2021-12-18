package pairmatching.service;

import pairmatching.model.MatchingHistory;
import pairmatching.model.PairMatching;
import pairmatching.util.InputSign;

public class PairMatchingService {
    private PairMatching pairMatching;
    private MatchingHistory matchingHistory;

    public boolean isQuit(String function) {
        return function.equals(InputSign.SIGN_QUIT);
    }
}
