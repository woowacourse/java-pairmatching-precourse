package pairmatching.source;

import pairmatching.constants.StringConstant;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String NOT_FOUND_ERROR= "존재하지 않는 코스입니다.";

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourseByName(String name){
        Course[] courses = Course.values();

        for(Course course : courses){
            if(course.name.equals(name)){
                return course;
            }
        }

        return null;
    }

    public String getName(){
        return this.name;
    }

    public static void checkExistCourse(String name) throws IllegalArgumentException{
        Course[] courses = Course.values();

        for(Course course : courses){
            if(course.name.equals(name)){
                return;
            }
        }

        throw new IllegalArgumentException(StringConstant.ERROR_MESSAGE_PREFIX +NOT_FOUND_ERROR);
    }
}
