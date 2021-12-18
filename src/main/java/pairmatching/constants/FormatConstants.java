package pairmatching.constants;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;

import java.util.List;

public class FormatConstants {

    public static String DIVIDER = "#############################################\n";
    public static String COURSES = "과정: 백엔드 | 프론트엔드\n";
    public static String MISSION = "미션:\n";

    public static String MISSION_FORMAT(Level level) {
        return "  - " + level.getName() + ": " + LIST_FORMAT(level);
    }

    public static String LIST_FORMAT(Level level) {
        List<Mission> missions = MissionRepository.getMissionsByLevel(level);
        if (missions.isEmpty()) return "";

        StringBuilder listFormat = new StringBuilder();
        for (Mission mission : missions) {
            listFormat.append(mission.getName());
            if (mission.equals(missions.get(missions.size()-1))) break;
            listFormat.append(" | ");
        }
        return listFormat.toString();
    }
}
