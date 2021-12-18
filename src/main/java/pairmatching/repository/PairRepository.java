package pairmatching.repository;

import pairmatching.domain.enumeration.Mission;
import pairmatching.domain.enumeration.Pairs;

import java.util.HashMap;
import java.util.Map;

public class PairRepository {
    private Map<Mission, Pairs> pairsMap = new HashMap<>();

    public void createPairs(Mission mission, Pairs pairs) {
        pairsMap.put(mission, pairs);
    }

    public Pairs findByMission(Mission mission) {
        return pairsMap.getOrDefault(mission, new Pairs());
    }

}
