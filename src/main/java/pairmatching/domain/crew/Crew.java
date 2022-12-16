package pairmatching.domain.crew;

import pairmatching.domain.item.Course;

public class Crew {

    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "course=" + course +
                ", name='" + name + '\'' +
                '}';
    }
}