package pairmatching.model.matching;

import java.util.*;
import java.util.concurrent.CountDownLatch;

import pairmatching.model.crew.*;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingSystem {
    private Set<MatchingHistory> matchingHistories = new HashSet<>();

    public boolean isMatchedBefore(Course course, Level level, Mission mission) {
        return matchingHistories.stream()
                .anyMatch(matchingHistory -> matchingHistory.isSameWith(course, level, mission));
    }

    public List<CrewPair> match(final List<String> crewNames, Course course, Level level, Mission mission) {
        List<CrewPair> matchedCrews;
        int shuffleCount = 0;
        while (true) {
            matchedCrews = match(crewNames, course);
            shuffleCount++;
            if (!hasPairMatchedBeforeInSameLevel(matchedCrews, level)) {
                break;
            }
            checkThreeTrial(shuffleCount);
        }
        addToHistory(matchedCrews, course, level, mission);
        return matchedCrews;
    }

    private List<CrewPair> match(final List<String> crewNames, final Course course) {
        List<String> shuffledNames = shuffle(crewNames);
        if (crewNames.size() % 2 == 0) {
            return matchCrewsOfEvenNumber(shuffledNames, course);
        }
        return matchCrewsOfOddNumber(shuffledNames, course);
    }

    private List<CrewPair> matchCrewsOfEvenNumber(List<String> shuffledNames, final Course course) {
        List<CrewPair> matchedPairs = new ArrayList<>();
        for (int i = 0; i < shuffledNames.size(); i += 2) {
            Crew first = Crew.of(shuffledNames.get(i), course);
            Crew second = Crew.of(shuffledNames.get(i + 1), course);
            matchedPairs.add(new CrewPair(first, second));
        }
        return matchedPairs;
    }

    private List<CrewPair> matchCrewsOfOddNumber(List<String> shuffledNames, final Course course) {
        List<CrewPair> matchedPairs = new ArrayList<>();
        for (int i = 0; i < shuffledNames.size(); i += 2) {
            if (i == shuffledNames.size() - 3) {
                Crew first = Crew.of(shuffledNames.get(i), course);
                Crew second = Crew.of(shuffledNames.get(i + 1), course);
                Crew third = Crew.of(shuffledNames.get(i + 2), course);
                matchedPairs.add(new CrewPair(first, second, third));
                break;
            }
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

    private void addToHistory(List<CrewPair> matchedCrews, Course course, Level level, Mission mission) {
        matchingHistories.add(new MatchingHistory(course, level, mission, matchedCrews));
    }

    public List<CrewPair> getMatchingHistoryOf(Course course, Level level, Mission mission) {
        MatchingHistory matchingHistory = matchingHistories.stream()
                .filter(history -> history.isSameWith(course, level, mission))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("매칭 이력이 없습니다."));
        return matchingHistory.getMatchedCrews();
    }

    public void reset() {
        matchingHistories = new HashSet<>();
    }
}
