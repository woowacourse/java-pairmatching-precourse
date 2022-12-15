package pairmatching.domain.choice.item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public static boolean contains(String name) {
        return Arrays.stream(values())
                .anyMatch(value -> name.equals(value.getCourseName()));
    }

    public static List<String> namesOfValues() {
        return Arrays.stream(values())
                .map(Course::getCourseName)
                .collect(Collectors.toList());
    }

    public static Course valueOfCourse(String courseName) {
        return Arrays.stream(values())
                .filter(value -> courseName.equals(value.getCourseName()))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 존재하지 않는 Course 입니다."));
    }
}
