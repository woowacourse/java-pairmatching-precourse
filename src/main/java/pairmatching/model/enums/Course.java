package pairmatching.model.enums;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String name;
    private final String fileName;

    Course(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getName() {
        return name;
    }

    public static boolean isContained(String name) {
        return Arrays.stream(Course.values())
                .anyMatch(course -> course.getName().equals(name));
    }

    public static Course findNameByValue(String value) {
        return Arrays.stream(Course.values())
                .filter(course -> course.getName().equals(value))
                .findFirst()
                .orElse(null);
    }
}