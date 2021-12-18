package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.List;
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

    public boolean isAlreadyMatchCrew(Level level, List<Match> matches) {
        return levelmissions.get(level).isAlreadyMatchCrew(matches);
    }

    public void updateMatch(Level level, Mission mission, List<Match> matches) {
        Mission currentMission = levelmissions.get(level).mission(mission);
        currentMission.updateMatch(matches);
    }

    public boolean isMatched(Level level, Mission mission) {
        checkExistMission(level, mission);
        return levelmissions.get(level).isMatched(mission);
    }

    public Mission getMission(Level level, Mission mission) {
        checkExistMission(level, mission);
        return levelmissions.get(level).mission(mission);
    }
}
