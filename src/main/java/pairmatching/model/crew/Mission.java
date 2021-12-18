package pairmatching.model.crew;

import java.util.Arrays;

public enum Mission {
    RACING_CAR(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1,"로또"),
    NUMBER_BASEBALL(Level.LEVEL1, "숫자야구게임"),

    CART(Level.LEVEL2, "장바구니"),
    PAYING(Level.LEVEL2, "결제"),
    SUBWAY(Level.LEVEL2, "지하철노선도"),

    ENHANCING(Level.LEVEL4, "성능개선"),
    RELEASING(Level.LEVEL4, "배포");

    private final String name;
    private final Level level;

    Mission(final Level level, final String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission of(final String nameValue, final String levelValue) {
        Level level = Level.of(levelValue);
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(nameValue) && mission.level == level)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("미션이름이 잘못되었거나, 미션에 대한 레벨이 올바르지 않습니다."));
    }
}
