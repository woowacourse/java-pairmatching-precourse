package pairmatching.repository;

import pairmatching.model.LevelAndMission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LevelAndMissionRepository {
    private static List<LevelAndMission> levelAndMissions = new ArrayList<>();

    public static List<LevelAndMission> levelAndMissions() {
        return Collections.unmodifiableList(levelAndMissions);
    }

    public static void addLevelAndMission(LevelAndMission levelAndMission) {
        levelAndMissions.add(levelAndMission);
    }

    public static Optional<LevelAndMission> getMissionsByLevelName(String level) {
        return levelAndMissions.stream()
                .filter(levelAndMission -> levelAndMission.getLevel().getLevelName().equals(level))
                .findAny();
    }
}
