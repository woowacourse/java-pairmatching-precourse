package pairmatching;

import java.util.Arrays;
import pairmatching.exception.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findByCourse(String name) {
        return Arrays.stream(Course.values())
            .filter(course -> course.name.equals(name))
            .findAny()
            .orElseThrow(ErrorMessage.NOT_FOUND_COURSE::getException);
    }
}
