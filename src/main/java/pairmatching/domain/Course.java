package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드")
    ;

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course of(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 과정명이 존재하지 않습니다."));
    }

    public String getName() {
        return name;
    }
}
