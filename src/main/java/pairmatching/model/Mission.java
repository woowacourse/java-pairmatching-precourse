package pairmatching.model;

public enum Mission {
    MISSION_RACE("자동차경주"),
    MISSION_LOTTO("로또"),
    MISSION_BASEBALL("숫자야구게임"),
    MISSION_BASKET("장바구니"),
    MISSION_PAYMENT("결제"),
    MISSION_SUBWAY("지하철노선도"),
    MISSION_PERFORMANCE("성능개선"),
    MISSION_DEPLOY("배포");

    private String name;

    Mission(String name) {
        this.name = name;
    }

    public String getMissionName() {
        return name;
    }
}