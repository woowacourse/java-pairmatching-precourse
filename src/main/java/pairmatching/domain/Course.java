package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.CourseNotFoundException;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourse(String name) {
        return Arrays.stream(values())
            .filter(course -> course.name.equals(name))
            .findFirst()
            .orElseThrow(CourseNotFoundException::new);
    }
}
