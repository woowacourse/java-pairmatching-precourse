package pairmatching.domain;

import java.util.List;

public class Crew {
    private Course course;
    private String name;
    private List<Crew> partner;

    public Crew (Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public Crew(String name) {
        this.name = name;
    }

    public void pair(Crew crew) {
        partner.add(crew);
    }

    public String getName() {
        return name;
    }
}
