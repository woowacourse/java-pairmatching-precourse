package pairmatching.utils;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class DetailValidation {
    // 없는 미션에 대한 예외를 처리한다.

    public static boolean missionExist(List<String> detailList){
        String position = detailList.get(0).trim();
        String level = detailList.get(1).trim();
        String test = detailList.get(2).trim();


        boolean courseCheckAnswer = CourseCheck(position);
        if(courseCheckAnswer==false)    return false;

        boolean levelCheckAnswer = levelCheck(level);
        if(levelCheckAnswer==false)    return false;


        String testOfLevel = Level.getTestList(level);

        List<String> tests = Arrays.asList(testOfLevel.split(","));

        boolean testCheckAnswer = testCheck(tests, test);
        if(testCheckAnswer==false)    return false;
        return true;
    }

    public static boolean CourseCheck(String position){
        List<String> courseList = Course.getCourseList();
        if(courseList.contains(position))   return true;
        return false;
    }

    public static boolean levelCheck(String level){
        List<String> levelList = Level.getLevelLists();
        if(levelList.contains(level))   return true;
        return false;
    }

    public static boolean testCheck(List<String> tests, String test){
        if(tests.contains(test))   return true;
        return false;
    }

}
