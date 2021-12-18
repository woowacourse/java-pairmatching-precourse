package pairmatching.System;

public enum SystemErrorMessage {
    NOT_MATCHING_HISTORY("[ERROR] 매칭 이력이 없습니다."),
    NOT_VALID_INPUT("[ERROR] 사용자의 입력값이 올바르지 않습니다."),
    NOT_ENTITY("[ERROR] 존재하지 않는 도메인 입니다.");

    private final String message;

    SystemErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
