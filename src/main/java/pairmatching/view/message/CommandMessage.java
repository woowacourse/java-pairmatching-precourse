package pairmatching.view.message;

public enum CommandMessage {
    MATCHING("%s. 페어 매칭\n"),
    CHECKING("%s. 페어 조회\n"),
    RESETTING("%s. 페어 초기화\n"),
    QUITTING("%s. 종료\n");

    private final String message;

    CommandMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object factor) {
        return String.format(message, factor);
    }
}
