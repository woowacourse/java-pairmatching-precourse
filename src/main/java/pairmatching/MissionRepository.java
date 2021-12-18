package pairmatching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissionRepository {

    private static final List<Mission> missions = new ArrayList<>();

    public static void addMission(Mission mission) {
        missions.add(mission);
    }

    public static Mission findByMission(String name) {
        return missions.stream().filter(mission -> mission.getName().equals(name)).findAny().get();
    }

    public static List<Mission> getMissions() {
        return Collections.unmodifiableList(missions);
    }
}
