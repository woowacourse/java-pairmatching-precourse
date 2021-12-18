package pairmatching.missionName;

public enum MissionName {
    RACING("자동차 주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),

    SHOPPING_BAG("장바구니"),
    PAY("결제"),
    METRO("지하철노선도"),

    IMPROVE_PERFORMANCE("성능개선"),
    DEPLOY("배포"),
    ;

    private String missionName;

    MissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionName() {
        return this.missionName;
    }
}
