package pairmatching;

import java.util.Arrays;
import java.util.List;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
