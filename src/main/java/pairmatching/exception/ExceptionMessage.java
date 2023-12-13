package pairmatching.exception;

public enum ExceptionMessage {
    INVALID_COMMAND("잘못된 입력값 입니다. 다시 입력해주세요. "
            + "(매칭 - 1, 조회 - 2, 초기화 - 3, 종료 - Q)"),
    INVALID_MATCHING_CONDITIONS("잘못된 입력 양식입니다. 다시 입력해주세요. (과정, 레벨, 미션)"),
    NON_EXISTENT_HISTORY("매칭 이력이 없습니다."),
    FAIL_MATCHING("매칭에 실패했습니다."),
    INVALID_REMATCHING_COMMAND("잘못된 입력 양식입니다. 다시 입력해주세요. (네, 아니오)"),
    PARSER_ERROR("파일을 읽을 수 없습니다.");

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
