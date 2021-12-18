package pairmatching.utils;


import pairmatching.domain.*;

public class Validator {

    public static void validateNumber(String target){
        if(!target.matches("[0-9]+")) throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER);
    }

    public static void validateInformationFormat(String information) {
        String regex = "[가-힣]+,\\s[가-힣]+,\\s[가-힣]+";
        if(!information.matches(regex)) throw  new IllegalArgumentException(ExceptionMessage.INCORRECT_INFORMATION_FORMAT);
    }

    public static void validateRematchFormat(String answer) {
        if(!(answer.equals(CommonConstant.YES) || answer.equals(CommonConstant.NO))) throw new IllegalArgumentException(ExceptionMessage.INCORRECT_INFORMATION_FORMAT);
    }


    public static void validateInformationContent(String[] information) {
        if(Course.getCourseByName(information[0]) == null) throw new IllegalArgumentException(ExceptionMessage.INVALID_INFORMATION_DATA + information[0]);
        if(Level.getLevelByName(information[1]) == null) throw new IllegalArgumentException(ExceptionMessage.INVALID_INFORMATION_DATA + information[1]);
        if(Mission.existMission(Level.getLevelByName(information[1]), information[2]) == null) throw new IllegalArgumentException(ExceptionMessage.INVALID_INFORMATION_DATA + information[2]);
    }

    public static void ValidateMatchable(int count) {
        if(count > 2) throw new IllegalArgumentException(ExceptionMessage.NOT_MATCHABLE);
    }
}
