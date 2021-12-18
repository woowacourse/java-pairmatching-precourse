package pairmatching.init;

public class Crew {
    private String Course;
    private String name;

    public Crew(String course, String name) {
        Course = course;
        this.name = name;
    }

    public String getCourse() {
        return Course;
    }

    public String getName() {
        return name;
    }
}
