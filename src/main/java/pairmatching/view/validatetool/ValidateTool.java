package pairmatching.view.validatetool;

public enum ValidateTool {

    COMMAND("\\w", "[ERROR] 기능 명령어는 한 글자여야 합니다.");

    private final String validFormat;
    private final String errorMessage;

    ValidateTool(String validFormat, String errorMessage) {
        this.validFormat = validFormat;
        this.errorMessage = errorMessage;
    }

    public String getValidFormat() {
        return validFormat;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
