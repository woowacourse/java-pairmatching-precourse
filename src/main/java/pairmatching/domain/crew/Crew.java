package pairmatching.domain.crew;

import java.util.Objects;

import pairmatching.domain.course.enums.CourseEnum;

public class Crew {
    private CourseEnum course;
    private String name;

    public Crew(CourseEnum course, String name) {
        this.course = course;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Crew crew = (Crew)o;
        return course == crew.course && Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, name);
    }
}
