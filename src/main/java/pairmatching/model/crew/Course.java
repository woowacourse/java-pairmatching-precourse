package pairmatching.model.crew;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course of(String courseName) {
        return Arrays.stream(values())
                .filter(course -> courseName.equals(course.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("코스의 이름이 잘못되었습니다."));
    }
}
