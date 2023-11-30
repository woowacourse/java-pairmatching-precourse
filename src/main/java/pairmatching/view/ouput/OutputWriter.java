package pairmatching.view.ouput;

import pairmatching.view.constant.InputMessage;
import pairmatching.view.constant.OutputMessage;
import pairmatching.view.constant.PrintFormat;

class OutputWriter {

    OutputWriter() {
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printfDoubleFormat(PrintFormat printFormat, Object object1, Object object2 ) {
        System.out.printf(printFormat.getFormat(), object1, object2);
    }

    public static void printfTripleFormat(PrintFormat printFormat, Object object1, Object object2, Object object3 ) {
        System.out.printf(printFormat.getFormat(), object1, object2, object3);
    }

    public static void printMessageResponse(OutputMessage responseMessage) {
        println(responseMessage.getMessage());
    }

}
