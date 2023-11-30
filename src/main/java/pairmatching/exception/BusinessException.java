package pairmatching.exception;

public class BusinessException extends IllegalArgumentException {
    private BusinessException(
            ErrorCode errorMessage,
            Exception exception
    ) {
        super(errorMessage.getMessage(), exception);
    }

    private BusinessException(ErrorCode errorMessage) {
        super(errorMessage.getMessage());
    }

    public static BusinessException of(
            ErrorCode errorMessage,
            Exception exception
    ) {
        return new BusinessException(errorMessage, exception);
    }

    public static BusinessException from(ErrorCode errorMessage) {
        return new BusinessException(errorMessage);
    }
}
