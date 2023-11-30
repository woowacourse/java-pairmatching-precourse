package pairmatching.view.input;

import pairmatching.util.InputUtil;
import pairmatching.view.constant.InputMessage;

public class InputView  {
    public static String InputChooseNumber() {
        System.out.println(InputMessage.REQUEST_CHOOSE_FEATURE.getMessage());
        return  InputUtil.readLine();
    }
}
