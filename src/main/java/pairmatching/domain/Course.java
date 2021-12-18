package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course parseCourse(String inputCourse) {
        return Arrays.stream(values())
            .filter(course -> course.getName().equals(inputCourse))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 코스입니다."));
    }

    public String getName() {
        return name;
    }
}