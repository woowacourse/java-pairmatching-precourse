package pairmatching.exception;

import static pairmatching.exception.ErrorCode.INVALID_INPUT;

import java.util.function.Supplier;
import pairmatching.view.ouput.ErrorOutputWriter;

public class ExceptionHandler {
    private ExceptionHandler() {
    }

    public static <T> T retryOnBusinessException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (BusinessException exception) {
                ErrorOutputWriter.println(exception.getMessage());
            }
        }
    }

    public static <T> T tryOnParseException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NumberFormatException exception) {
            throw BusinessException.of(INVALID_INPUT, exception);
        }
    }
}
