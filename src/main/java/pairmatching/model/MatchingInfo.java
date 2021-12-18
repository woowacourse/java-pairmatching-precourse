package pairmatching.model;

import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;

import java.util.List;

public class MatchingInfo {
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
}
