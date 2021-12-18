package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course ofName(String originName){
        return Arrays.stream(values())
                .filter(n -> originName.equals(n.name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 코스입니다."));
    }



}