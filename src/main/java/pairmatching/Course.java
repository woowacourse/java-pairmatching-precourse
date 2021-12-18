package pairmatching;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static String findByCourse(String name) {
        return Arrays.stream(Course.values())
            .filter(course -> course.name.equals(name))
            .findAny()
            .orElseThrow(IllegalArgumentException::new)
            .name;
    }
}
