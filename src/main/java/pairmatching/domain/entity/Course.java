package pairmatching.domain.entity;

import java.util.Arrays;
import pairmatching.util.ExceptionUtil;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String description;
    private final String filePath;

    Course(final String description, final String filePath) {
        this.description = description;
        this.filePath = filePath;
    }

    public static Course findCourse(String courseName) {
        return Arrays.stream(values())
                .filter(course -> course.description.equals(courseName))
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public String getDescription() {
        return description;
    }

    public String getFilePath() {
        return filePath;
    }
}