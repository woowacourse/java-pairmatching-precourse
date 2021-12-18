package pairmatching.domain.enumeration;

import pairmatching.utils.ErrorMessages;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findCourseByInput(String input) {
        return Arrays.stream(Course.values())
                .filter(courseName -> courseName.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.PREFIX_ERROR + ErrorMessages.ERROR_INVALID_INPUT));
    }
}