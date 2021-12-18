package pairmatching.constant;

public enum ErrorMessage {
    OVER_LENGTH("[ERROR] 메뉴 선택은 한 글자로 입력되어야 합니다."),
    BLANK("[ERROR] 입력이 비어있습니다."),
    NOT_EXIST_OPTION("[ERROR] 존재 하지 않는 선택지입니다."),

    NOT_EXIST_COURSE("[ERROR] 존재하지 않는 코스입니다."),
    NOT_EXIST_LEVEL("[ERROR] 존재하지 않는 레벨입니다."),
    NOT_EXIST_MISSION("[ERROR] 존재하지 않는 미션입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
