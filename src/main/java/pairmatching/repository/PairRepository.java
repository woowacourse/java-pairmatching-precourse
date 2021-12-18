package pairmatching.repository;

import pairmatching.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class PairRepository {
    private static final List<Pair> pairs = new ArrayList<>();

    public static List<Pair> pairs() {
        return Collections.unmodifiableList(pairs);
    }

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

    public static void addPair(List<Crew> crews, MatchInfo matchInfo) {
        pairs.add(new Pair(crews, matchInfo));
    }

    public static List<Pair> findPairsByMatchInfo(MatchInfo matchInfo) {
        return pairs.stream()
                .filter(pair -> pair.getCourse().equals(matchInfo.getCourse()))
                .filter(pair -> pair.getLevel().equals(matchInfo.getLevel()))
                .filter(pair -> pair.getMission().equals(matchInfo.getMission()))
                .collect(Collectors.toList());
    }
}
