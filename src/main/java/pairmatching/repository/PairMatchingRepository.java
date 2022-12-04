package pairmatching.repository;

import pairmatching.model.Mission;
import pairmatching.model.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingRepository {
    private final Map<Mission, List<Pair>> matchedPairs = new HashMap<>();
}
