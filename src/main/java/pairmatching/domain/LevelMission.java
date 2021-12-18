package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import pairmatching.exception.MissionNotFoundException;

public class LevelMission {

    private final Map<Level, Missions> levelmissions;

    public LevelMission(Map<Level, Missions> levelmissions) {
        this.levelmissions = levelmissions;
    }

    public static LevelMission init() {
        Map<Level, Missions> levelMissions = new LinkedHashMap<>();
        Level.levels().forEach(level -> levelMissions.put(level, Missions.init()));
        return new LevelMission(levelMissions);
    }

    public void checkExistMission(Level level, Mission mission) {
        if (!levelmissions.containsKey(level) || levelmissions.get(level).isContainMission(mission)) {
            throw new MissionNotFoundException();
        }
    }

    public boolean isAlreadyMatch(Level level, Mission mission) {
        checkExistMission(level, mission);
        return levelmissions.get(level).isAlreadyMatch(mission);
    }
}
