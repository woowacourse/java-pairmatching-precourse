package pairmatching.domain;

import java.util.List;

public class Crew {
    private Course course;
    private String name;

    Crew(final String name, final Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }
}
