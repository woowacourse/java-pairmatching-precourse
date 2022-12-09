package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findMatchingCourse(String courseInput){
        return Arrays.stream(Course.values())
                .filter(course -> course.hasCourse(courseInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재자나이!"));
    }

    private boolean hasCourse(String courseInput) {
        return this.name.equals(courseInput);
    }


}
