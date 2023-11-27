package pairmatching.domain.entity;

import java.util.List;

public class MatchingResult {
    private final List<Pair> pairs;

    private MatchingResult(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public static MatchingResult create(List<Pair> pairs) {
        return new MatchingResult(pairs);
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
