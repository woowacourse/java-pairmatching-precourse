package pairmatching.controller.mainmenu;

public enum Option {
    MATCHING("1", "페어 매칭"),
    INQUIRY("2", "페어 조회"),
    INIT("3", "페어 초기화"),
    QUIT("4", "종료");

    private String option;
    private String detail;

    Option(String option, String detail) {
        this.option = option;
        this.detail = detail;
    }

    public String getOption() {
        return option;
    }

    public String getDetail() {
        return detail;
    }
}
