package pairmatching.model;

import java.util.Arrays;

import pairmatching.util.Message;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course parseCourse(String input) {
        return Arrays.stream(values())
            .filter(menu -> menu.name.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Message.COURSE_ERROR));
    }

    public String getName() {
        return name;
    }
}