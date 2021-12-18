package pairmatching.domain;

import java.util.List;

public class MatchResult {

    private Course course;
    private Level level;
    private Mission mission;
    private List<Pair> pairs;

    public MatchResult(Course course, Level level, Mission mission, List<Pair> pairs) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairs = pairs;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
