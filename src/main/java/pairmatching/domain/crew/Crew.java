package pairmatching.domain.crew;

import pairmatching.domain.course.Course;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public static Crew of(String name, Course course) {
        return new Crew(name, course);
    }

    public boolean isName(String comparison) {
        return this.name.equals(comparison);
    }

    public String getName() {
        return name;
    }
}
