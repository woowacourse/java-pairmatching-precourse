package pairmatching;

import java.util.HashSet;
import java.util.Set;

public class Crew {
    private Course course;
    private String name;
    private Set<Level> levels;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
        this.levels = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean isEqualToCourse(Course course) {
        return this.course == course;
    }

    public boolean isEqualToName(String name) {
        return this.name.equals(name);
    }
}