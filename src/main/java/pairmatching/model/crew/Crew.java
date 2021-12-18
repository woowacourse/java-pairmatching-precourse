package pairmatching.model.crew;

import java.util.Objects;

public class Crew {
    private final Course course;
    private final String name;

    public static Crew of(final String name, final Course course) {
        return new Crew(name, course);
    }

    private Crew(final String name, Course course) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return course == crew.course && Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, name);
    }
}
