package pairmatching.view.ouput;

import static pairmatching.exception.ErrorCode.INVALID_NUMBER_INPUT;

public final class ErrorOutputWriter extends OutputWriter {
    private ErrorOutputWriter() {
        super();
    }

    public static void invalidInput(String input) {
        System.out.println(INVALID_NUMBER_INPUT.getMessage());
    }
}
