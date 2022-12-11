package pairmatching.repository;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MissionRepository {
    private static final List<Mission> missions = new ArrayList<>();

    public static void save(Level level, String missionName) {
        missions.add(Mission.of(level, missionName));
    }

    public static Map<Level, List<String>> findAllNamesByAllLevel() {
        HashMap<Level, List<String>> model = new HashMap<>();
        for (Level level : Level.values()) {
            List<String> missionNames = findAllNamesByLevel(level);
            model.put(level, missionNames);
        }
        return model;
    }

    private static List<String> findAllNamesByLevel(Level level) {
        return missions.stream()
                .filter(mission -> mission.isLevel(level))
                .map(Mission::getName)
                .collect(Collectors.toList());
    }

    public static boolean isExistingWith(Level level, String missionName) {
        return missions
                .stream()
                .filter(mission -> mission.isLevel(level))
                .anyMatch(mission -> mission.isName(missionName));
    }
}
