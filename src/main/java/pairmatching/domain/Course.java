package pairmatching.domain;

import static pairmatching.ui.Messages.NON_EXISTENT_COURSE;

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
                .orElseThrow(() -> new IllegalArgumentException(NON_EXISTENT_COURSE.getMessage()));
    }

    private boolean hasCourse(String courseInput) {
        return this.name.equals(courseInput);
    }


}
