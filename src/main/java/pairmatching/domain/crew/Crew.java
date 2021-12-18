package pairmatching.domain.crew;

import pairmatching.domain.course.Course;

public class Crew {
    private Course course;
    private String name;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}
