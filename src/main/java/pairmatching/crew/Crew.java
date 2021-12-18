package pairmatching.crew;

import java.util.ArrayList;
import java.util.List;

public class Crew {

    private Course course;
    private String name;

    private Crew(){}

    public static Crew fromCourseAndName(Course course, String name) {
        Crew crew = new Crew();
        crew.course = course;
        crew.name = name;
        return crew;
    }

    public String getName() {
        return name;
    }
}
