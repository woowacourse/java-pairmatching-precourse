package pairmatching.util.io.message;

public enum Options {
    // for what to do
    WHAT_TO_DO_1("1. 페어 매칭"),
    WHAT_TO_DO_2("2. 페어 조회"),
    WHAT_TO_DO_3("3. 페어 초기화"),
    WHAT_TO_DO_4("Q. 종료")
    ;
    private String message;

    Options(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
