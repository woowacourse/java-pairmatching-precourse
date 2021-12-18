package pairmatching.view.message;

public enum ErrorMessage {
    ERROR_NOT_CORRECT_FORMAT("[ERROR] \"과정, 레벨, 미션\" 형식이어야 합니다."),
    ERROR_NOT_FUNCTION_INPUT_SIGN("[ERROR] \"1, 2, 3, Q\" 중에서 답해야 합니다."),
    ERROR_NOT_YES_OR_NO_SIGN("[ERROR] \"네, 아니오\" 중에서 답해야 합니다."),

    ERROR_NOT_EXIST_COURSE("[ERROR] 존재하지 않은 과정입니다."),
    ERROR_NOT_EXIST_LEVEL("[ERROR] 존재하지 않은 레벨입니다."),
    ERROR_NOT_EXIST_MISSION("[ERROR] 존재하지 않은 미션입니다."),

    ERROR_CANNOT_MATCH_ANY_MORE("[ERROR] 더이상 해당 조건으로 매칭할 수 없습니다."),
    ERROR_CANNOT_MATCH("[ERROR] 해당 조건으로 매칭할 수 없습니다."),
    ERROR_NO_MATCHING_HISTORY("[ERROR] 매칭 이력이 없습니다."),

    ERROR_CANNOT_READ_FILE("[ERROR] 파일을 읽는 중 오류가 발생하였습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
