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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Crew)) {
            return false;
        }
        Crew c = (Crew)o;
        return isCourse(c.course) && isName(c.name);
    }

    public boolean isCourse(Course course) {
        return this.course.toString().equals(course.toString());
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }
}
