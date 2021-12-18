package pairmatching.view;

import pairmatching.model.*;

import java.util.List;
import java.util.Map;

import static pairmatching.constant.OutputConstant.*;

public class OutputView {
    public static void functionInfo(){
        System.out.println(MSG_OUTPUT_HASH);
        outputCourse();
        outputMission();
        System.out.println(MSG_OUTPUT_HASH);
    }

    private static void outputCourse(){
        System.out.print(MSG_OUTPUT_COURSE);
        List<Course> courseList = CourseLevelInfo.getCourseList();
        for(Course course : courseList){
            System.out.print(course.getName());
            System.out.print(PARTITION);
        }
        System.out.println();

    }

    private static void outputMission(){
        System.out.println(MSG_OUTPUT_MISSION);
        Map<Level, List<Game>> levelMission = CourseLevelInfo.getLevelMission();
        for(Map.Entry<Level, List<Game>> m: levelMission.entrySet()){
            System.out.print(STICK + m.getKey().getName() + COLON);
            for(Game game : m.getValue()){
                System.out.print(game.getName());
                System.out.print(PARTITION);
            }
            System.out.println();
        }
    }

    public static void outputMatchingResult(PairMatching pairMatching){
        System.out.println(MSG_OUTPUT_MATCHING_RESULT);
        List<List<Crew>> matchingList = pairMatching.getPairPerson();
        for(List<Crew> list : matchingList){
            for(Crew crew : list){
                System.out.print(crew.getName());
                System.out.print(" : ");
            }
            System.out.println();
            System.out.println();
        }

    }

    public static void outputReset(){
        System.out.println(MSG_OUTPUT_RESET);
        System.out.println();
    }


}
