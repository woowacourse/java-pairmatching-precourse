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

    public static List<String> getList() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .sequential()
                .collect(Collectors.toList());
    }

    public static boolean isExist(String name) {
        List<Course> result = Arrays.stream(Course.values())
                .filter(course -> course.getName().equals(name))
                .collect(Collectors.toList());
        if (result.size() == 1) {
            return true;
        }
        return false;
    }

    public static Course getEnumCourse(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.getName().equals(name))
                .collect(Collectors.toList()).get(0);
    }
}
