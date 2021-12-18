package pairmatching.domain.crew;

import pairmatching.domain.course.Course;

public class Crew {
    private Course course;
    private String name;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Crew crew) {
        return (isCourse(crew.course) && isName(crew.name));
    }

    public boolean isCourse(Course course) {
        return this.course.toString().equals(course.toString());
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }
}
