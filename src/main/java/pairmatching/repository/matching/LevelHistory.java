package pairmatching.repository.matching;

import java.util.HashMap;

public class LevelHistory {
    HashMap<String, MissionHistory> missionHistories = new HashMap<>();

    public boolean isMatched(String mission) {
        if (missionHistories.containsKey(mission)) {
            return true;
        }
        return false;
    }

    /*public boolean isPaired(String... crews) {

    }*/
}
