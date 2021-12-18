package pairmatching.domain.mission;

import pairmatching.domain.Level;
import pairmatching.domain.course.Course;

public class Mission {
    private final Course course;
    private final Level level;
    private final MissionName name;

    public Mission(Course course, Level level, MissionName name) {
        this.course = course;
        this.level = level;
        this.name = name;
    }

    public static Mission of(Course course, Level level, MissionName name) {
        return new Mission(course, level, name);
    }

    public boolean isName(String comparison) {
        return name.isSame(comparison);
    }
}
