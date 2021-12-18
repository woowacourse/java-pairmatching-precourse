package pairmatching.domain.enumeration;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자야구게임"),
    SHOPPING_CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_PATH("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DEPLOYMENT("배포");

    private String missionName;

    public String getMissionName() {
        return missionName;
    }

    Mission(String missionName) {
        this.missionName = missionName;
    }
}
