package pairmatching.ui;

public enum Messages {
    INVALID_INPUT_STRUCT("잘못된 입력 형식입니다."),
    NON_EXISTENT_LEVEL("존재하지 않는 레벨 정보입니다."),
    NON_EXISTENT_COURSE("존재하지 않는 코스 정보입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
