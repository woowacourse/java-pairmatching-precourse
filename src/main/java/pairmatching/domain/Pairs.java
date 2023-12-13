package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {

    private final MatchingConditions matchingConditions;
    private final List<Pair> pairs;

    public Pairs(MatchingConditions matchingConditions) {
        this.matchingConditions = matchingConditions;
        this.pairs = new ArrayList<>();
    }

    public void add(Pair pair) {
        pairs.add(pair);
    }

    public MatchingConditions getMatchingConditions() {
        return matchingConditions;
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }
}
