package pairmatching.domain;

import java.util.List;

public class PairMatchingRecord {
    private MatchingChoice matchingChoice;
    private List<Pair> matchingResult;

    public MatchingChoice getMatchingChoice() {
        return matchingChoice;
    }
}
