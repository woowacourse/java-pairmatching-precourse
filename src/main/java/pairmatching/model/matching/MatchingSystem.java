package pairmatching.model.matching;

import java.util.*;

import pairmatching.model.crew.*;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingSystem {
    private final Set<MatchingHistory> matchingHistories = new HashSet<>();

    public boolean isMatchedBefore(List<String> courseAndLevelAndMission) {
        Course course = Course.of(courseAndLevelAndMission.get(0));
        Level level = Level.of(courseAndLevelAndMission.get(1));
        Mission mission = Mission.of(courseAndLevelAndMission.get(1), courseAndLevelAndMission.get(2));
        return matchingHistories.stream()
                .anyMatch(matchingHistory -> matchingHistory.hasMatchedBeforeInConditionOf(course, level, mission));
    }

    public List<CrewPair> match(final List<String> crewNames, List<String> courseAndLevelAndMission) {
        List<CrewPair> matchedCrews;
        int shuffleCount = 0;
        while (true) {
            matchedCrews = match(crewNames, courseAndLevelAndMission.get(0));
            shuffleCount++;
            if (!hasPairMatchedBeforeInSameLevel(matchedCrews, Level.of(courseAndLevelAndMission.get(1)))) {
                break;
            }
            checkThreeTrial(shuffleCount);
        }
        addToHistory(matchedCrews, courseAndLevelAndMission);
        return matchedCrews;
    }

    private List<CrewPair> match(final List<String> crewNames, final String course) {
        List<String> shuffledNames = shuffle(crewNames);
        List<CrewPair> matchedPairs = new ArrayList<>();
        for (int i = 0; i < crewNames.size(); i += 2) {
            Crew first = Crew.of(shuffledNames.get(i), course);
            Crew second = Crew.of(shuffledNames.get(i + 1), course);
            matchedPairs.add(new CrewPair(first, second));
        }
        return matchedPairs;
    }

    private boolean hasPairMatchedBeforeInSameLevel(List<CrewPair> matchedCrews, final Level level) {
        return matchingHistories.stream()
                .anyMatch(matchingHistory -> matchingHistory.hasMatchedBeforeInSameLevel(matchedCrews, level));
    }

    private void checkThreeTrial(int shuffleCount) {
        if (shuffleCount == 3) {
            throw new IllegalArgumentException("3회의 매칭을 시도했지만 실패했습니다.");
        }
    }

    private void addToHistory(List<CrewPair> matchedCrews, List<String> courseAndLevelAndMission) {
        Course course = Course.of(courseAndLevelAndMission.get(0));
        Level level = Level.of(courseAndLevelAndMission.get(1));
        Mission mission = Mission.of(courseAndLevelAndMission.get(1), courseAndLevelAndMission.get(2));
        matchingHistories.add(new MatchingHistory(course, level, mission, matchedCrews));
    }
}
