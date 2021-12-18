package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.Map;

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
}
