package pairmatching.model.matching;

import pairmatching.model.crew.Course;
import pairmatching.model.crew.CrewPair;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;

import java.util.List;

public class MatchingHistory {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<CrewPair> matchedCrews;

    public MatchingHistory(final Course course, final Level level,
                           final Mission mission, final List<CrewPair> matchedCrews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.matchedCrews = matchedCrews;
    }

    public boolean isSameWith(Course course, Level level, Mission mission) {
        return this.course == course && this.level == level && this.mission == mission;
    }

    public boolean hasMatchedBeforeInSameLevel(final List<CrewPair> matchedCrews, final Level level) {
        if (this.level != level) {
            return false;
        }
        return this.matchedCrews.stream()
                .anyMatch(before -> hasMatchedBeforeInSameLevel(before, matchedCrews));
    }

    private boolean hasMatchedBeforeInSameLevel(final CrewPair before, List<CrewPair> newPairs) {
        return newPairs.stream()
                .anyMatch(before::isSameCaseWith);
    }

    public List<CrewPair> getMatchedCrews() {
        return matchedCrews;
    }
}
