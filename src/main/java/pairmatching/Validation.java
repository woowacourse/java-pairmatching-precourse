package pairmatching;

public class Validation {

    public static void validateChoiceFeature(String featureNum){
        if(!featureNum.equals("1") && !featureNum.equals("2") && !featureNum.equals("3") && !featureNum.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 기능 선택이 잘못 입력되었습니다.");
        }
    }
}
