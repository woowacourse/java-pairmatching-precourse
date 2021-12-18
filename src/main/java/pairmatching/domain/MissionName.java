package pairmatching.domain;

public enum MissionName {
    RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    PUSH("배포");

    private String name;

    MissionName(String name) {
        this.name = name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

}
