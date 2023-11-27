package domain.entity;

import java.util.Arrays;
import util.ExceptionUtil;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String name;
    private final String filePath;

    Course(final String name, final String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public static Course findCourse(String courseName) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(courseName))
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }
}