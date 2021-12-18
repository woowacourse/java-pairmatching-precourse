package pairmatching.infomation;

import java.util.ArrayList;

public class Course {
    private static final ArrayList<String> courses = new ArrayList<>();

    static {
        courses.add("백엔드");
        courses.add("프론트엔드");
    }

    public static ArrayList<String> getCourses() {
        return courses;
    }
}
