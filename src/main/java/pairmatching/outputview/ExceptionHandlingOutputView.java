package pairmatching.outputview;

public class ExceptionHandlingOutputView {

    public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public static void printExceptionMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
