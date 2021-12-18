package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현

//    public static List<Course> getCourseList(){
//        return Arrays.stream(Course.values()).collect(Collectors.toList());
//    }

    public String getValue(){return name;};

    public static List<String> getCourseList (){
        List<String> courseList = new ArrayList<String>();
        for(Course course : Course.values()){
            courseList.add(course.getValue());
        }
        return courseList;
    }
}
