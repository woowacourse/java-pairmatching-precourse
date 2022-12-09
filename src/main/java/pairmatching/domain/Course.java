package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String COURSE_ERROR_MESSAGE = "[ERROR] 과정명을 잘못 입력하셨습니다.";

    private final String name;

    Course(String name){
        this.name = name;
    }

    public static Course ofName(String name){
        return Arrays.stream(values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException(COURSE_ERROR_MESSAGE));
    }

    public String getName(){
        return name;
    }
}
