package pairmatching.view.constant;

public enum OutputMessage {
    RESPONSE_CHARGE("잔돈");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
