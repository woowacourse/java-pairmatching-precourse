package pairmatching.domain.item;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String ERROR_MESSAGE = "[ERROR] %s 과정은 존재하지 않습니다.";
    private final String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public static Course valueOfCourse(String name) {
        return Arrays.stream(values())
                .filter(value -> name.equals(value.getCourseName()))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(String.format(ERROR_MESSAGE, name)));
    }

    public String getCourseName() {
        return courseName;
    }
}
