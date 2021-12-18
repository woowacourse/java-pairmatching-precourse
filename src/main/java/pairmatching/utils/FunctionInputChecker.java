package pairmatching.utils;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.StringConstant;

public class FunctionInputChecker {
    private static final String FUNCTION_INPUT_ERROR = "올바른 기능을 선택해 주세요";
    private static final String FUNCTION_INPUT_REQUEST = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";


    public static String getFunctionInput(){
        String input;
        do{
            System.out.println(FUNCTION_INPUT_REQUEST);
            input = Console.readLine();
        }while(!checkIsRightInput(input));

        return input;
    }

    private static boolean checkIsRightInput(String input){

        try {
            checkExistFunction(input);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }

    private static void checkExistFunction(String input) throws IllegalArgumentException{

        for(String symbol : StringConstant.FUNCTION_SYMBOL){
            if(symbol.equals(input)){
                return;
            }
        }

        throw new IllegalArgumentException(StringConstant.ERROR_MESSAGE_PREFIX + FUNCTION_INPUT_ERROR);
    }
}
