package pairmatching.domain.matching;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.pair.Pairs;

public class MatchingResults {
    private Map<MatchingCondition, Pairs> matchingResults = new HashMap<>();

    public void add(MatchingCondition matchingCondition, Pairs pairs) {
        matchingResults.put(matchingCondition, pairs);
    }

    public void initialize() {
        matchingResults.clear();
    }

    public boolean cotains(MatchingCondition matchingCondition) {
        return matchingResults.containsKey(matchingCondition);
    }

    public Pairs getPairs(MatchingCondition matchingCondition) {
        return matchingResults.get(matchingCondition);
    }
}
