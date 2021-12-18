package pairmatching.util.error;

public enum ErrorType {
    NOT_VALID_CHOOSEN("[ERROR] 올바르지 못한 입력입니다.");

    private String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
