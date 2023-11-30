package pairmatching.exception;

import java.util.function.BooleanSupplier;

public enum ErrorCode {
    INVALID_NUMBER_INPUT("유효하지 않은 기능입니다. 다시 입력해주세요."),
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해주세요.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public void validate(BooleanSupplier condition) {
        if (isSameCondition(condition)) {
            throw BusinessException.from(this);
        }
    }

    private boolean isSameCondition(BooleanSupplier condition) {
        return condition.getAsBoolean();
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
