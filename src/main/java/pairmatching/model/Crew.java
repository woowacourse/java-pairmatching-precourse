package pairmatching.model;

public class Crew {
    private String course;
    private String name;

    Crew(String course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
