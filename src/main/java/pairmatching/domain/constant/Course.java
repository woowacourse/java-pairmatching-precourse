package pairmatching.domain.constant;

import java.util.Arrays;
import pairmatching.exception.ExceptionMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String input) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(input))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                ExceptionMessage.INVALID_MATCHING_CONDITIONS.getMessage()));
    }

    public String getName() {
        return name;
    }
}
