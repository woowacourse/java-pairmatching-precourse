package pairmatching.constants;

public enum ErrorMessage {
    INPUT_CHOICE_ERROR("[ERROR] 1, 2, 3, Q 중에 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
