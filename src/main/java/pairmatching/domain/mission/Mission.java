package pairmatching.domain.mission;

import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;

public class Mission {
    private Course course;
    private Level level;
    private String name;

    public boolean isSameLevel(Mission mission) {
        return this.level.isSameLevel(mission.level);
    }
}
