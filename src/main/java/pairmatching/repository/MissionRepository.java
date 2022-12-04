package pairmatching.repository;

import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissionRepository {
    private final List<Mission> missions = new ArrayList<>();

    public void saveAllNamesWithLevel(List<String> missionNames, Level level) {
        missions.addAll(missionNames.stream()
                .map(missionName -> new Mission(level, missionName))
                .collect(Collectors.toList()));
    }

    public List<String> findAllNamesByLevel(Level level) {
        return missions.stream()
                .filter(mission -> mission.getLevel() == level)
                .map(Mission::getName)
                .collect(Collectors.toList());
    }
}
