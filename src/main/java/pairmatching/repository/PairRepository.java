package pairmatching.repository;

import pairmatching.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PairRepository {
    private static List<Pair> pairs = new ArrayList<>();

    public static Optional<Course> findCourseByName(String courseName) {
        return Arrays.stream(Course.values())
                .filter(c -> c.getCourseName().equals(courseName))
                .findAny();
    }

    public static Optional<Level> findLevelByName(String levelName) {
        return Arrays.stream(Level.values())
                .filter(c -> c.getLevelName().equals(levelName))
                .findAny();
    }

    public static Optional<Mission> findMissionByName(String missionName) {
        return Arrays.stream(Mission.values())
                .filter(c -> c.getMissionName().equals(missionName))
                .findAny();
    }

    public static int countPairsByAll(Course course, Level level, Mission mission) {
        return (int) pairs.stream()
                .filter(pair -> pair.getCourse().equals(course))
                .filter(pair -> pair.getLevel().equals(level))
                .filter(pair -> pair.getMission().equals(mission))
                .count();
    }

    public static boolean alreadyMetPairInSameLevel(List<Crew> crews, Level level) {
        return pairs.stream()
                .filter(pair -> pair.getLevel().equals(level))
                .anyMatch(pair -> pair.getCrews().equals(crews));
    }
}
