package pairmatching.domain;

import java.util.Arrays;

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

    public static Mission findBy(String name) {
        return Arrays.stream(Mission.values()).filter(mission -> mission.isSameName(name)).findFirst().get();
    }

    private boolean isSameName(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
