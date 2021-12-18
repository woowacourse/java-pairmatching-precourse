package pairmatching;

import pairmatching.missionName.MissionName;

import java.util.*;

public class MissionManager {

    private Map<Level, List<Mission>> missionMap = new HashMap<Level, List<Mission>>(){{
        put(Level.LEVEL1, new ArrayList<Mission>());
        put(Level.LEVEL2, new ArrayList<Mission>());
        put(Level.LEVEL3, new ArrayList<Mission>());
        put(Level.LEVEL4, new ArrayList<Mission>());
        put(Level.LEVEL5, new ArrayList<Mission>());
    }};

    public void init() {
        for (Level level : Level.values()) {
            initializeMissionMap(level);
        }
    }

    public void initializeMissionMap(Level level) {
        for (MissionName missionName : LevelMission.levelMissionMap.get(level)) {
            missionMap.get(level).add(new Mission(Course.FRONTEND, missionName));
            missionMap.get(level).add(new Mission(Course.BACKEND, missionName));
        }
    }

    public List<Pair> getPairList(Course course, Level level, MissionName missionName) {
        return missionMap.get(level).stream()
                .filter(mission -> mission.getMissionName() == missionName)
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .getPairList();
    }

    public List<Mission> getMissionListOfLevel(Level level) {
        return missionMap.get(level);
    }
}
