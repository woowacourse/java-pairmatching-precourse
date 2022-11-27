package pairmatching.domain;

import java.util.List;

public class MatchInfo {
    private Course course;
    private Level level;
    private Mission mission;
    private List<List<Crew>> pair;

    public MatchInfo(Course course, Level level, Mission mission, List<List<Crew>> pair) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pair = pair;
    }
    public List<List<Crew>> getPairInfo() {
        return pair;
    }
}
