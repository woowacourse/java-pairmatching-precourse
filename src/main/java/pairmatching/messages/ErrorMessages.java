package pairmatching.messages;

public enum ErrorMessages {

    INVALID_FUNCTION("타당하지 않은 기능입니다."),
    INVALID_COURSE_MISSION("타당하지 않은 과정, 레벨, 미션입니다."),
    INVALID_REMATCHING_SELECT("타당하지 않은 선택입니다.");

    private final String message;
    private static final String prefix = "[ERROR] ";

    ErrorMessages(final String message) {
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
