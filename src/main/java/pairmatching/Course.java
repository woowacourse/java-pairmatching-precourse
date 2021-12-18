package pairmatching;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");


    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course of(String courseName){
        return Arrays.stream(values())
            .filter(v->courseName.equals(v.name))
            .findFirst()
            .orElseThrow(()->new IllegalArgumentException());
    }
}
