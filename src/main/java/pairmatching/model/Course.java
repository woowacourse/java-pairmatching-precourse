package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
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
