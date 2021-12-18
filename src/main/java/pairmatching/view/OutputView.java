package pairmatching.view;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }
}
