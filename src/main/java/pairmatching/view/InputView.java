package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import static pairmatching.constant.InputConstant.*;
public class InputView {

    public static String inputFunctionSelect(){
        System.out.println(MSG_INPUT_FUNCTION_SELECT);
        System.out.println(MSG_INPUT_FUNCTION_SELECT_MATCHING);
        System.out.println(MSG_INPUT_FUNCTION_SELECT_SEARCH);
        System.out.println(MSG_INPUT_FUNCTION_SELECT_RESET);
        System.out.println(MSG_INPUT_FUNCTION_SELECT_END);
        return Console.readLine();
    }


}
