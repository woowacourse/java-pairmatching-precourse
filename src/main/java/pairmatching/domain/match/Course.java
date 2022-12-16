package pairmatching.domain.match;

import java.util.Arrays;

import static pairmatching.util.Validator.ERROR_PREFIX;

public enum Course {

    BACKEND("백엔드"), FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course checkExistCourse(String inputCourse) {
        return Arrays.stream(values())
                .filter(course -> inputCourse.equals(course.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 코스입니다."));
    }
}
