package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    public static final String INVALID_COURSE_NAME_MESSAGE = "주어진 이름과 일치하는 코스가 없습니다.";
    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findByName(String courseName) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COURSE_NAME_MESSAGE));
    }

    // 추가 기능 구현

    public String getName() {
        return name;
    }

    public static List<String> getCourseNames() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());
    }
}
