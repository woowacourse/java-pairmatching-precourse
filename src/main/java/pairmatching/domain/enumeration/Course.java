package pairmatching.domain.enumeration;

import pairmatching.utils.ConstantMessages;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course findCourseByInput(String input) {
        return Arrays.stream(Course.values())
                .filter(course -> course.getName().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ConstantMessages.PREFIX_ERROR + ConstantMessages.ERROR_INVALID_INPUT));
    }
}