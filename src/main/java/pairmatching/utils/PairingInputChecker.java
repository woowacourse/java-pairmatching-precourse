package pairmatching.utils;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.StringConstant;

public class PairingInputChecker {
    private static final String FORM_REGEX = "[\\w가-힣]+,\\s[\\w가-힣]+,\\s[\\w가-힣]+";

    private static final String PAIRING_INPUT_REQUEST = "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private static final String PAIRING_INPUT_ERROR = "입력 형식을 지켜주세요";


    public static String getPairingInput(){
        String input;
        do{
            System.out.println(PAIRING_INPUT_REQUEST);
            input = Console.readLine();
        }while(!checkIsRightInput(input));

        return input;
    }

    private static boolean checkIsRightInput(String input){

        try {
            checkInputForm(input);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }

    private static void checkInputForm(String input) throws IllegalArgumentException{

        if(!input.matches(FORM_REGEX)){
            throw new IllegalArgumentException(StringConstant.ERROR_MESSAGE_PREFIX + PAIRING_INPUT_ERROR);
        }
    }
}
