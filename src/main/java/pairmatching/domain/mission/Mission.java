package pairmatching.domain.mission;

import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.matcher.Pairs;

public class Mission {
    private Course course;
    private Level level;
    private String name;
    private Pairs Pair;

    public boolean isSameLevel(Mission mission) {
        return this.level.isSameLevel(mission.level);
    }
}
