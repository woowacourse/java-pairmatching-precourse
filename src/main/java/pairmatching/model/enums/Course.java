package pairmatching.model.enums;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean isContained(String name) {
        return Arrays.stream(Level.values())
                .anyMatch(level -> level.getName().equals(name));
    }

    public static Course findNameByValue(String value) {
        return Arrays.stream(Course.values())
                .filter(course -> course.getName().equals(value))
                .findFirst()
                .orElse(null);
    }
}