package repository;

import model.Level;
import model.Mission;

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
}
