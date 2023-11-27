package pairmatching.repository.matching;

import java.util.HashMap;
import java.util.Set;
import pairmatching.domain.Pair;

public class LevelHistory {
    HashMap<String, MissionHistory> missionHistories = new HashMap<>();

    public boolean isMatched(String mission) {
        if (missionHistories.containsKey(mission)) {
            return true;
        }
        return false;
    }

    public boolean isDuplicated(Set<Pair> pairs) {
        return missionHistories.values().stream()
                .map(MissionHistory::getPairs)
                .flatMap(Set::stream)
                .anyMatch(pairs::contains);
    }

    public void save(String mission, Set<Pair> pairs) {
        missionHistories.put(mission, new MissionHistory(pairs));
    }

    /*public boolean isPaired(String... crews) {

    }*/
}
