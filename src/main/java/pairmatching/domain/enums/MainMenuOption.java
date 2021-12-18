package pairmatching.domain.enums;

public enum MainMenuOption {
    SELECT_MENU("기능을 선택하세요."),
    PAIR_MATCHING("1. 페어 매칭"),
    LOOKUP_PAIR("2. 페어 조회"),
    PAIR_INITIALIZE("3. 페어 초기화"),
    QUIT("Q. 종료");

    private String message;

    MainMenuOption(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
