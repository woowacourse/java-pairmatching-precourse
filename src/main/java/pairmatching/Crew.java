package pairmatching;

public class Crew {

    private Course course;
    private String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean checkCourse(Course course) {
        return this.course.equals(course);
    }

    public String getName() {
        return this.name;
    }
}
