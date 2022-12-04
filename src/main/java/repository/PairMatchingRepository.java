package repository;

import model.Mission;
import model.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingRepository {
    private final Map<Mission, List<Pair>> matchedPairs = new HashMap<>();
}
