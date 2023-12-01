package pairmatching.domain;

import java.util.List;

public class MatchingHistory {
    private Course course;
    private List<Pair> pair;

    public MatchingHistory(Course course, List<Pair> pair) {
        this.course = course;
        this.pair = pair;
    }

    public Course getCourse() {
        return course;
    }

    public List<Pair> getPair() {
        return pair;
    }
}
