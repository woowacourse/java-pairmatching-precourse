package pairmatching.domain.entity;

import java.util.List;

public class MatchingResult {
    private final List<Pair> pairs;

    public MatchingResult(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
