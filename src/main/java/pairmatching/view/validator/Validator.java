package pairmatching.view.validator;

public enum Validator {
    COMMAND("\\w{1}", "[ERROR] 기능 선택은 한 개의 문자만 입력이 가능합니다.\n"),
    CHOICE(".{3,5},.{4},.{3,7}", "[ERROR] 올바른 입력이 아닙니다. \", \"로 구분하여 과정, 레벨, 미션을 입력하십시오.\n"),
    RE_MATCHING("([가-힣]{1}|[가-힣]{3})", "[ERROR] %s는 잘못된 입력입니다. 네, 아니오 중 한 가지를 입력하십시오.\n");

    private final String validFormat;
    private final String errorMessage;

    Validator(String validFormat, String errorMessage) {
        this.validFormat = validFormat;
        this.errorMessage = errorMessage;
    }

    public String getValidFormat() {
        return validFormat;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void validate(String input) {
        if (isInvalidFormat(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean isInvalidFormat(String input) {
        return !input.matches(validFormat);
    }
}
