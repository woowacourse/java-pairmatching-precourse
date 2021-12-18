package pairmatching.crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.exception.ErrorMessage;

public class MissionRepository {
    private static final List<Mission> missions = new ArrayList<>();

    public static void addMission(Mission mission) {
        missions.add(mission);
    }

    public static Mission findByMission(String name) {
        return missions.stream()
            .filter(mission -> mission.getName().equals(name))
            .findAny()
            .orElseThrow(ErrorMessage.NOT_FOUND_MISSION::getException);
    }

    public static List<Mission> getMissions() {
        return Collections.unmodifiableList(missions);
    }

    public static Mission getPairList(Course course, String mission, Level level) {
        return missions.stream()
            .filter(thisMissions -> thisMissions.equalTo(mission, level))
            .findAny()
            .filter(findMission -> findMission.getPairs().get(0).getCrews().get(0).isEqualToCourse(course))
            .orElseThrow(ErrorMessage.NOT_FOUND_PAIR::getException);
    }

    public static void clear() {
        missions.clear();
    }

    public static boolean existPair(String name) {
        return !missions.stream()
            .filter(mission -> mission.getName().equals(name))
            .findAny()
            .get()
            .getPairs().isEmpty();
    }
}
