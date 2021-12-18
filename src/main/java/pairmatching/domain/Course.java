package pairmatching.domain;

import static pairmatching.ErrorMessage.*;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"), FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course find(String name) {
        return Arrays.stream(Course.values())
            .filter(course -> course.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NO_OBJECT_ERROR));
    }
}
