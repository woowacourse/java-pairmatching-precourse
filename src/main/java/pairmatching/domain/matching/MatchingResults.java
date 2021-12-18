package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.pair.Pair;

public class MatchingResults {
    private Map<MatchingCondition, List<Pair>> matchingResults = new HashMap<>();

    public void match(MatchingCondition matchingCondition) {
    }
}
