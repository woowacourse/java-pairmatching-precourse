package pairmatching.view.validatetool;

public enum ValidateTool {

    COMMAND("\\w", "[ERROR] 기능 명령어는 한 글자여야 합니다."),
    CHOICE(".{1,10},.{3,5},.{1,10}", "[ERROR] 선택 입력 형식이 잘못되었습니다."),
    RE_MATCHING("\\[가-힣]{1,3}", "[ERROR] 입력 형식이 잘못되었습니다.");

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
