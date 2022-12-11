package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    public static final String NOT_EXISTING_COURSE_NAME = "존재하지 않는 과정 이름";
    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findByName(String courseName) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTING_COURSE_NAME));
    }

    // 추가 기능 구현

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
