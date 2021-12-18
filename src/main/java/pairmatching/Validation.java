package pairmatching;

import java.util.ArrayList;

public class Validation {

    static int COURSE_NAME = 0;
    static int LEVEL_NAME = 1;
    static int MISSION_NAME = 2;

    public static void validateChoiceFeature(String featureNum){
        if(!featureNum.equals("1") && !featureNum.equals("2") && !featureNum.equals("3") && !featureNum.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 기능 선택이 잘못 입력되었습니다.");
        }
    }

    public static void validateCourseAndLevel(String[] pairMatchingArray){
        if(!pairMatchingArray[COURSE_NAME].equals("백엔드") && !pairMatchingArray[COURSE_NAME].equals("프론트엔드")){
            throw new IllegalArgumentException("[ERROR] 과정이 잘못 입력되었습니다.");
        }
        if(!pairMatchingArray[LEVEL_NAME].equals("레벨1") && !pairMatchingArray[LEVEL_NAME].equals("레벨2") && !pairMatchingArray[LEVEL_NAME].equals("레벨3") && !pairMatchingArray[LEVEL_NAME].equals("레벨4")
                && !pairMatchingArray[LEVEL_NAME].equals("레벨5")){
            throw new IllegalArgumentException("[ERROR] 레벨이 잘못 입력되었습니다.");
        }
    }

    public static void validateMission(String[] pairMatchingArray){
        if(pairMatchingArray[LEVEL_NAME].equals("레벨1") && !pairMatchingArray[MISSION_NAME].equals("자동차경주") && !pairMatchingArray[MISSION_NAME].equals("로또") && !pairMatchingArray[MISSION_NAME].equals("숫자야구게임")){
            throw new IllegalArgumentException("[ERROR] 미션이 잘못 입력되었습니다.");
        }
        if(pairMatchingArray[LEVEL_NAME].equals("레벨2") && !pairMatchingArray[MISSION_NAME].equals("장바구니") && !pairMatchingArray[MISSION_NAME].equals("결제") && !pairMatchingArray[MISSION_NAME].equals("지하철노선도")){
            throw new IllegalArgumentException("[ERROR] 미션이 잘못 입력되었습니다.");
        }
        if(pairMatchingArray[LEVEL_NAME].equals("레벨3") || pairMatchingArray[LEVEL_NAME].equals("레벨5")){
            throw new IllegalArgumentException("[ERROR] 선택하신 레벨의 미션이 없습니다.");
        }
        if(pairMatchingArray[LEVEL_NAME].equals("레벨4") && !pairMatchingArray[MISSION_NAME].equals("성능개선") && !pairMatchingArray[MISSION_NAME].equals("배포")){
            throw new IllegalArgumentException("[ERROR] 미션이 잘못 입력되었습니다.");
        }
    }

    public static boolean validateMeetList(ArrayList<String> meetList, String name){
        for(String met: meetList){
            if(met.equals(name)){
                return true;
            }
        }
        return false;
    }

    public static boolean insertYesOrNo(String answer){
        if(answer.equals("아니오")){
            return true;
        }
        return false;
    }

    public static String[] trimString(String[] arr){
        String[] trimArray = new String[3];
        try{
            for(int i = 0; i < arr.length; i++){
                trimArray[i] = arr[i].trim();
            }
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션을 한가지씩 입력해야 합니다.");
        }
        return trimArray;
    }

    public static void checkMatchCount(int count){
        if(count > 3){
            throw new IllegalArgumentException("[ERROR] 더 이상 매칭을 시도할 수 없습니다.");
        }

    }

}
