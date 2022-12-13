package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String CourseName;

    Course(String CourseName) {
        this.CourseName = CourseName;
    }

    public static Course from(String name) {
        return Arrays.stream(values())
                .filter(course -> course.CourseName.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 과정을 입력하셨습니다."));
    }

}
