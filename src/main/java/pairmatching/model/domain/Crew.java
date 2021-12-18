package pairmatching.model.domain;

import pairmatching.model.domain.Course;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}