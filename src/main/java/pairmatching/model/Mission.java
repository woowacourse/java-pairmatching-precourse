package pairmatching.model;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL_GAME("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_MAP("지하철노선도"),
    IMPROVING_PERFORMANCE("성능 개선"),
    DISTRIBUTION("배포"),
    NOTHING("(없음)");

    private String mission;

    Mission(final String mission) {
        this.mission = mission;
    }

}
