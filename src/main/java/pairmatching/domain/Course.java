package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static boolean isCourseName(String name) {
        if(getAllCourse().stream().anyMatch(course -> course.name.equals(name))) {
            return true;
        };
        return false;
    }

    public static Optional<Course> findByName(String name) {
        return getAllCourse().stream().filter(course -> course.name.equals(name)).findAny();
    }

    private static List<Course> getAllCourse() {
        return Arrays.asList(values());
    }
}
