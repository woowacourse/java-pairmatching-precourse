package pairmatching.domain.course.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CourseEnum {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    public String getName() {
        return name;
    }

    CourseEnum(String name) {
        this.name = name;
    }
}
