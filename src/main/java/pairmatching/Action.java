package pairmatching;

public enum Action {
    PAIR_MATCHING("1. 페어 매칭", "1"),
    PAIR_SEARCHING("2. 페어 조회", "2"),
    PAIR_RESET("3. 페어 초기화", "3"),
    END("Q. 종료", "Q");

    private String name;
    private String number;

    Action(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }
}
