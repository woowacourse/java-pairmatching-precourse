package pairmatching.view.message;

public enum Message {
    COMMAND_GUIDE("기능을 선택하세요.\n"),
    DIVIDING_LINE("#############################################"),
    COURSE("과정: %s"),
    MISSION("미션:"),
    LEVEL("- %s: %s"),
    DELIMITER(" | "),
    CHOICE_GUIDE("과정, 레벨, 미션을 선택하세요."),
    CHOICE_EXAMPLE("ex) 백엔드, 레벨1, 자동차경주"),
    NEW_LINE("\n"),
    RE_MATCHING_GUIDE("매칭 정보가 있습니다. 다시 매칭하시겠습니까?"),
    RE_MATCHING_EXAMPLE("네 | 아니오");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... factors) {
        return String.format(message, factors);
    }
}
