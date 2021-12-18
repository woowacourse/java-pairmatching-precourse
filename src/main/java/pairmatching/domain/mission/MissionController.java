package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.HashMap;

import pairmatching.domain.level.Level;

public class MissionController {
    private final HashMap<String, ArrayList<Mission>> missionTable = new HashMap<>();

    public void initializeMissions() {
        missionTable.clear();
        for (Level level : Level.values()) {
            missionTable.put(level.getName(), new ArrayList<Mission>());
        }

        for (BaseMission baseMission : BaseMission.values()) {
            addMission((baseMission));
        }
    }

    private void addMission(BaseMission mission) {
        missionTable.get(mission.getMission().getName()).add(mission.getMission());
    }
}
