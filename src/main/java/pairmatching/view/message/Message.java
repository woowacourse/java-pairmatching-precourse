package pairmatching.view.message;

public enum Message {
    COMMAND_GUIDE("기능을 선택하세요.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object factor) {
        return String.format(message, factor);
    }
}
