package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static boolean isCourseName(String name) {
        if(getAllLevel().stream().anyMatch(course -> course.name.equals(name))) {
            return true;
        };
        return false;
    }

    private static List<Course> getAllLevel() {
        return Arrays.asList(values());
    }

}
