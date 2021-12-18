package pairmatching.domain;

import java.util.List;

public class MatchingInfo {
    private List<List<String>> pairList;
    private Course course;
    private Level level;
    private String mission;

    public MatchingInfo(final List<List<String>> pairList, final Course course, final Level level,
        final String mission) {
        this.pairList = pairList;
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public boolean equals(final Course course, final Level level, final String mission) {
        if (course == this.course && level == this.level && mission == this.mission) {
            return true;
        }
        return false;
    }

    public List<List<String>> getPairList() {
        return pairList;
    }
}
