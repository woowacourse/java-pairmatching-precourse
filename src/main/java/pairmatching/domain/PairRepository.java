package pairmatching.domain;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.crew.Crew;

public class PairRepository {
    private final Map<String, Pair> backendCrew = new HashMap<>();

    public void save(String missionName, Pair pair) {
        backendCrew.put(missionName, pair);
    }

    public Pair findByMissionName(String missionName) {
        return backendCrew.get(missionName);
    }
}
