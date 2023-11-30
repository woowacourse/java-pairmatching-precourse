package pairmatching.view.input;

import java.util.List;
import pairmatching.util.InputUtil;
import pairmatching.util.Parser;
import pairmatching.view.constant.InputMessage;

public final class InputView  {
    public static String inputChooseNumber() {
        System.out.println(InputMessage.REQUEST_CHOOSE_FEATURE.getMessage());
        return  InputUtil.readLine();
    }

    public static List<String> inputChooseProcess(){
        System.out.println(InputMessage.REQUEST_CHOOSE_PROCESS.getMessage());
        String process = InputUtil.readLine();
        return Parser.parseProcessInput(process);
    }
}
