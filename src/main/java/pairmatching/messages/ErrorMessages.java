package pairmatching.messages;

public enum ErrorMessages {

    INVALID_FUNCTION("타당하지 않은 기능입니다."),
    INVALID_COURSE_MISSION("타당하지 않은 과정, 레벨, 미션입니다."),
    NOT_EXIST_MATCHING_RESULT("매칭 이력이 없습니다."),
    INVALID_REMATCHING_SELECT("타당하지 않은 선택입니다."),
    FAIL_TO_MATCH("매칭 실패");

    private static final String prefix = "[ERROR] ";
    private final String message;

    ErrorMessages(final String message) {
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
