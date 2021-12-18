package pairmatching.constants;

import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.Pair;

import java.util.List;

public class OutputMessages {

    public static String DIVIDER = "#############################################\n";
    public static String COURSES = "과정: 백엔드 | 프론트엔드\n";
    public static String MISSION = "미션:\n";

    public static String MISSION_FORMAT(Level level) {
        return "  - " + level.getName() + ": " + LIST_FORMAT(level) + "\n";
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

    public static String MATCH_RESULT = "페어 매칭 결과입니다.\n";

    public static String PAIR_FORMAT(Pair pair) {
        StringBuilder pairFormat = new StringBuilder();
        List<Crew> crewList = pair.getCrews();
        int crewNum = crewList.size();
        for (int idx = 0; idx < crewNum; idx++) {
            pairFormat.append(crewList.get(idx).getName());
            if (idx == crewNum-1) break;
            pairFormat.append(" : ");
        }
        return pairFormat + "\n";
    }

}
