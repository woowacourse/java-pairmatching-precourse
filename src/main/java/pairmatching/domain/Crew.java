package pairmatching.domain;

import java.util.Arrays;

public class Crew {
    private Course course;
    private String name;

    public Crew(String courseName, String name) {
        this.course = Arrays.stream(Course.values())
                .filter(c -> c.isSameName(courseName))
                .findFirst()
                .orElse(null);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "course=" + course +
                ", name='" + name + '\'' +
                '}';
    }
}
