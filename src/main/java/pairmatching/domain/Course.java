package pairmatching.domain;

import java.util.Arrays;
import pairmatching.util.ExceptionMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_COURSE.getMessage()));
    }
}