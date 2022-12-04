package pairmatching.repository;

import pairmatching.model.Pair;
import pairmatching.vo.PairMatchingInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingRepository {
    private final Map<PairMatchingInfo, List<Pair>> matchedPairs = new HashMap<>();

    public void save(PairMatchingInfo pairMatchingInfo, List<Pair> pairs) {
        matchedPairs.put(pairMatchingInfo, pairs);
    }
}
