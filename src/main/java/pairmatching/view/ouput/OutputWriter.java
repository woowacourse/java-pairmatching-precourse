package pairmatching.view.ouput;

import pairmatching.view.constant.InputMessage;
import pairmatching.view.constant.OutputMessage;

class OutputWriter {

    OutputWriter() {
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMessageResponse(OutputMessage responseMessage) {
        println(responseMessage.getMessage());
    }

    public static void printMessageRequest(InputMessage requestMessage) {
        println(requestMessage.getMessage());
    }
}
