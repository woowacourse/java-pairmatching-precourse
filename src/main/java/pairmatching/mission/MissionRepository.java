package pairmatching.mission;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.MissionInitializer;

public class MissionRepository {

    private static final List<Mission> missions = new ArrayList<>(
        MissionInitializer.getAvailableMissions()
    );
    private static final String ERR_NAME_NOT_EXIST = "이름이 없습니다.";
    private static final String ERR_LEVEL_NOT_EXIST = "레벨이 없습니다.";

    public boolean add(Mission mission) {
        return missions.add(mission);
    }

    public boolean add(List<Mission> missions) {
        return MissionRepository.missions.addAll(missions);
    }

    public static Mission findByName(String name) {
        return missions.stream()
            .filter(m -> m.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ERR_NAME_NOT_EXIST));
    }

    public static List<Mission> findByLevel(Level level) {
        return missions.stream()
            .filter(m -> m.isLevelMatched(level))
            .collect(Collectors.toList());
    }
}
