package pairmatching.exception;

public enum ExceptionMessage {
    INVALID_COMMAND("잘못된 입력값 입니다. 다시 입력해 주세요. "
            + "(매칭 - 1, 조회 - 2, 초기화 - 3, 종료 - Q)"),
    NON_EXISTENT_HISTORY("매칭 이력이 없습니다.");

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
