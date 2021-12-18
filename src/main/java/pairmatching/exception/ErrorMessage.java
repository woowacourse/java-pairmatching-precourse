package pairmatching.exception;

public enum ErrorMessage {
    INVALID_COMMAND(new IllegalArgumentException("[ERROR] 존재하지 않는 기능 선택입니다."));

    private final IllegalArgumentException exception;

    ErrorMessage(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}
