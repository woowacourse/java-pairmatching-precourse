package pairmatching.view.input;

import static pairmatching.util.Parser.*;

import java.util.List;
import pairmatching.util.InputUtil;
import pairmatching.util.Parser;
import pairmatching.view.constant.InputMessage;

public final class InputView  {
    public static String inputChooseNumber() {
        System.out.println(InputMessage.REQUEST_CHOOSE_FEATURE.getMessage());
        return  InputUtil.readLine();
    }

    public static String inputChooseProcess(){
        System.out.println(InputMessage.REQUEST_CHOOSE_PROCESS.getMessage());
        String inputInfo =  InputUtil.readLine();
        return validProcessinfInfo(inputInfo);
    }

    public static boolean reInputChooseProcess(){
        System.out.println(InputMessage.REQUEST_REINPUT_PROCESS.getMessage());
         String answer = InputUtil.readLine();
         return parseInputOfMatchingHistory(answer);
    }

}
