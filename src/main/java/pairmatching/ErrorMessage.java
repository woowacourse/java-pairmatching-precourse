package pairmatching;

public enum ErrorMessage {
    WRONG_INPUT_MESSAGE("입력형식이 잘못되었습니다."),
    MISSION_NOT_FOUND_MESSAGE("없는 미션입니다."),
    EMPTY_ERROR_MESSAGE("매칭 이력이 없습니다.");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
