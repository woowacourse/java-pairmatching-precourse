package pairmatching.mission;

import java.util.ArrayList;
import java.util.List;

public class MissionRepository {

    private static final List<Mission> missions = new ArrayList<>();
    private static final String ERR_NAME_NOT_EXIST = "이름이 없습니다.";

    public boolean add(Mission mission) {
        return missions.add(mission);
    }

    public boolean add(List<Mission> missions) {
        return MissionRepository.missions.addAll(missions);
    }

    public Mission findByName(String name) {
        return missions.stream()
            .filter(m -> m.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ERR_NAME_NOT_EXIST));
    }
}
