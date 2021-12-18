package pairmatching.model;

import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;

import java.util.List;
import java.util.stream.Collectors;

public class MatchingInfo {
    private static final String SEPARATOR = "\n";
    private List<Pair> matchingPairs;
    private Course course;
    private Level level;
    private String mission;

    public MatchingInfo(String course, String level, String mission) {
        this.course = Course.findNameByValue(course);
        this.level = Level.findNameByValue(level);
        this.mission = mission;
    }

    public List<Pair> getMatchingPairs() {
        return matchingPairs;
    }

    public Course getCourse() {
        return course;
    }

    public void setMatchingPairs(List<Pair> matchingPairs) {
        this.matchingPairs = matchingPairs;
    }

    public Level getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }

    public boolean isSameMatching(MatchingInfo matchingInfo) {
        return this.course == matchingInfo.getCourse()
                && this.level == matchingInfo.getLevel()
                && this.mission.equals(matchingInfo.getMission());
    }

    public boolean isSameCourseAndLevel(Course course, Level level) {
        return this.course == course
                && this.level == level;
    }

    @Override
    public String toString() {
        return String.join(SEPARATOR, convertPairToStringList());
    }

    private List<String> convertPairToStringList() {
        return matchingPairs.stream()
                .map(Pair::toString)
                .collect(Collectors.toList());
    }
}
