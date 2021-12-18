package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> getCourseList() {
        return Arrays.asList(Course.values()).stream().map(course -> course.getName()).collect(Collectors.toList());
    }
}
