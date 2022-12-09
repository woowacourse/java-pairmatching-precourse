package pairmatching.domain;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Crew : " +
                "course = " + course +
                ", name = '" + name + '\'' +
                '}';
    }

    public boolean matches(Crew crew) {
        return this.equals(crew);
    }

    public boolean takesSameCourse(Course course) {
        return this.course == course;
    }

    public String getName() {
        return name;
    }
}
