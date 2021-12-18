package pairmatching.domain;

public enum Mission {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    IMPROVEMENT_PERFORMANCE("성능개선"),
    DISTRIBUTE("배포"),
    EMPTY("");

    private String name;

    Mission(String name) {
        this.name = name;
    }
}
