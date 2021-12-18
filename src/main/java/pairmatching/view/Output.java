package pairmatching.view;

import pairmatching.util.Constant;
import pairmatching.util.Message;

public class Output {

    private Output() {
    }

    public static void guideMessage(String message) {
        System.out.println(message);
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(String.format(Constant.ERROR_FORMAT, Message.ERROR, errorMessage));
    }
}
