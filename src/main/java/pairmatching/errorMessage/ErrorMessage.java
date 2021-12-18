package pairmatching.errorMessage;

public enum ErrorMessage {
    DUPLICATE_PAIR("이미 페어인 크루입니다.")
    ;

    public static final String ERROR_PREFIX = "[ERROR]";

    private String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getCompleteMessage() {
        return ERROR_PREFIX + getText();
    }

}

