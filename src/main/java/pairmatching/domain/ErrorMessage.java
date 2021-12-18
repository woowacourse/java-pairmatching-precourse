package pairmatching.domain;

public class ErrorMessage {
    public static final String PREFIX = "[ERROR]";

    public static String makeErrorMessage(String errorMessage) {
        return PREFIX + " " + errorMessage;
    }
}
