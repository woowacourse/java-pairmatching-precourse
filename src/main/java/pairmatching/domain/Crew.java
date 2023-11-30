package pairmatching.domain;

import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;

public class Crew {
    private final Course course;
    private final Level level;
    private final String mission;
    private final String name;

    private Crew(Course course, Level level, String mission, String name) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.name = name;
    }


    public static Crew of(Course course, Level level, String mission, String name) {
        return new Crew(course, level,mission,name);
    }

    public String getName() {
        return name;
    }
}
