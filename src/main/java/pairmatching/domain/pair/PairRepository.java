package pairmatching.domain.pair;

import java.util.HashMap;
import java.util.Map;

public class PairRepository {
    private final Map<String, Pair> pairs = new HashMap<>();

    public void save(String missionName, Pair pair) {
        pairs.put(missionName, pair);
    }

    public Pair findByMissionName(String missionName) {
        return pairs.get(missionName);
    }
}
