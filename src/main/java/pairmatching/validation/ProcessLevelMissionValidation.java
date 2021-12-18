package pairmatching.validation;

import pairmatching.model.CourseLevelInfo;
import static pairmatching.constant.ErrorConstant.*;

public class ProcessLevelMissionValidation {

    public static String[] isValidation(String input){
        String[] info = input.split(", ");
        isSize(info);
        isCourse(info[0]);
        isLevel(info[1]);
        isMission(info[2]);
        return info;
    }

    private static void isSize(String[] info){
        if(info.length !=3){
            throw new IllegalArgumentException(MSG_ERROR_FORM);
        }
    }

    private static void isCourse(String course){
        if(!CourseLevelInfo.existCourse(course)){
            throw new IllegalArgumentException(MSG_ERROR_COURSE);
        }
    }
    private static void isLevel(String level){
        if(!CourseLevelInfo.existLevel(level)){
            throw new IllegalArgumentException(MSG_ERROR_LEVEL);
        }
    }
    private static void isMission(String mission){
        if(!CourseLevelInfo.existMission(mission)){
            throw new IllegalArgumentException(MSG_ERROR_GAME);
        }
    }

}
