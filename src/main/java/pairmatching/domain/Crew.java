package pairmatching.domain;

import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;

public class Crew {
    private String name;
    private Course course;
    private Level level;
    private String mission;

    public Crew(String name, Course course, Level level, String mission) {
        this.name = name;
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    // Getter and Setter methods
}
