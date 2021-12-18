package pairmatching.validation;

import static pairmatching.constant.ErrorConstant.*;

public class FunctionSelectValidation {
    private static final Character CHECK_ONE = '1';
    private static final Character CHECK_TWO = '2';
    private static final Character CHECK_THREE = '3';
    private static final Character CHECK_Q = 'Q';

    public static void isCorrect(String input){
        if(input.length() != 1){
            throw new IllegalArgumentException(MSG_ERROR_FUNCTION_SELCET);
        }
        if(input.charAt(0) != CHECK_ONE && input.charAt(0) != CHECK_TWO && input.charAt(0) != CHECK_THREE && input.charAt(0) != CHECK_Q){
            throw new IllegalArgumentException(MSG_ERROR_FUNCTION_SELCET);
        }
    }
}
