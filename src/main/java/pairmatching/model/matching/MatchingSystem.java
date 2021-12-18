package pairmatching.model.matching;

import pairmatching.model.crew.Course;
import pairmatching.model.crew.CrewPair;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;

import java.util.ArrayList;
import java.util.List;

public class MatchingSystem {
    private final List<MatchingHistory> matchingHistories = new ArrayList<>();

    public boolean isMatchedBefore(List<String> courseAndLevelAndMission) {
        Course course = Course.of(courseAndLevelAndMission.get(0));
        Level level = Level.of(courseAndLevelAndMission.get(1));
        Mission mission = Mission.of(courseAndLevelAndMission.get(1), courseAndLevelAndMission.get(2));
        return matchingHistories.stream()
                .anyMatch(matchingHistory -> matchingHistory.hasMatchedBeforeInConditionOf(course, level, mission));
    }
}
