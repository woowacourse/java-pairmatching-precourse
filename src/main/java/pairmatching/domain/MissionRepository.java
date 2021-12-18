package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MissionRepository {

    private static final List<Mission> missions = new ArrayList<>();

    public static List<Mission> getMissions() { return missions; }

    public static List<Mission> getMissionsByLevel(Level level) {
        List<Mission> missionList = new ArrayList<>();
        for (Mission mission : missions) {
           if(mission.getLevel() != level) continue;
            missionList.add(mission);
        }
        return missions;
    }

    public static void addMission(Mission mission) {
            missions.add(mission);
        }
}
