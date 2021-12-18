package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName(){
        return name;
    }

    public static List<Course> list(){
        List<Course> courseList = new ArrayList<>();
        for(Course course : Course.values()){
            courseList.add(course);
        }
        return courseList;
    }

}