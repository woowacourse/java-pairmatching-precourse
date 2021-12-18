package pairmatching.domain;

public class Crew {
    private Course course;
    private String name;

    public Crew(String crewName) {
        name = crewName;
    }

    @Override
    public String toString() {
        return name;
    }
}
