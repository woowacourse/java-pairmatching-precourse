package pairmatching.exception;

public enum ErrorMessage {
    NOT_FOUND_COMMAND(new IllegalArgumentException("[ERROR] 존재하지 않는 기능 선택입니다.")),
    NOT_FOUND_COURSE(new IllegalArgumentException("[ERROR] 존재하지 않는 과정입니다."));

    private final IllegalArgumentException exception;

    ErrorMessage(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}
