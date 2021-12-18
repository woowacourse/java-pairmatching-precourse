package pairmatching.domain.crew;

import pairmatching.domain.course.enums.CourseEnum;

public class Crew {
    private CourseEnum course;
    private String name;

    public Crew(CourseEnum course, String name) {
        this.course = course;
        this.name = name;
    }
}
