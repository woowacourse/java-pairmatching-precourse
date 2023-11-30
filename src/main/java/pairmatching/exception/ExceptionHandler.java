package pairmatching.exception;

import java.util.function.Supplier;

public class ExceptionHandler {
    private ExceptionHandler() {
    }

    public static <T> T retryOnBusinessException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (BusinessException exception) {
                Output.ErrorOutputWriter.println(exception.getMessage());
            }
        }
    }

    public static <T> T tryOnParseException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NumberFormatException exception) {
            throw BusinessException.of(ErrorCode.INVALID_INPUT, exception);
        }
    }
}
