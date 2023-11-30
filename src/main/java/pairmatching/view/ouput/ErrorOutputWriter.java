package pairmatching.view.ouput;

import static pairmatching.exception.ErrorCode.INVALID_NUMBER_INPUT;

public final class ErrorOutputWriter extends OutputWriter {
    private ErrorOutputWriter() {
        super();
    }

    public static void invalidInput() {
        System.out.println(INVALID_NUMBER_INPUT.getMessage());
    }
}
