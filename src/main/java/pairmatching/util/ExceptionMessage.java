package pairmatching.util;

public enum ExceptionMessage {
    NO_MAIN_OPTION("해당하는 메인 옵션이 존재하지 않습니다."),
    NO_SUCH_COURSE("해당 과정은 존재하지 않습니다."),
    NO_SUCH_LEVEL("해당 레벨이 존재하지 않습니다."),
    NO_SUCH_MISSION_IN_SUCH_LEVEL("해당 레벨에 해당 미션이 존재하지 않습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}
