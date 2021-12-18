package pairmatching.domain;

import pairmatching.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.Optional;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    BACKEND_FILENAME("../../../resources/backend-crew.md"),
    FRONTEND_FILENAME("../../../resources/frontend-crew.md");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        if (BACKEND.name.equals(this.name)) return BACKEND_FILENAME.name;
        return FRONTEND_FILENAME.name;
    }

    public static Course getCourseByName(String name){
        return Arrays.stream(Course.values())
                .filter(value -> value.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_INFORMATION_DATA));
    }
}