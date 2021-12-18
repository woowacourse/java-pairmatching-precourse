package pairmatching.repository;

import pairmatching.model.LevelAndMission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelAndMissionRepository {
    private static List<LevelAndMission> levelAndMissions = new ArrayList<>();

    public static List<LevelAndMission> levelAndMissions() {
        return Collections.unmodifiableList(levelAndMissions);
    }

    public static void addLevelAndMission(LevelAndMission levelAndMission) {
        levelAndMissions.add(levelAndMission);
    }
}
