package pairmatching;

public enum ErrorMessage {
    WRONG_INPUT_MESSAGE("[ERROR] 입력형식이 잘못되었습니다."),
    MISSION_NOT_FOUND_MESSAGE("[ERROR] 없는 미션입니다.");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
