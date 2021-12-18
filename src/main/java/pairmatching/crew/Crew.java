package pairmatching.crew;

import pairmatching.course.Course;

public class Crew {
    private Course course;
    private String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getCourseName() {
        return this.course.getName();
    }

    public Course getCourse() {
        return this.course;
    }
}
