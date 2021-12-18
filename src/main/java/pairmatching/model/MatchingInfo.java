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

    public boolean isSameMatching(String course, String level, String mission) {
        return this.course.getName().equals(course)
                && this.level.getName().equals(level)
                && this.mission.equals(mission);
    }
}
