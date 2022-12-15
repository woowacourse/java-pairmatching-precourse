package pairmatching.domain.choice.item;

import java.util.Arrays;

public enum Mission {
    CAR_RACING("자동차 경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    NUMBER_BASEBALL("숫자야구게임", Level.LEVEL1),
    SHOPPING_BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_MAP("지하철노선도", Level.LEVEL2),
    IMPROVEMENT_OF_PERFORMANCE("성능개선", Level.LEVEL4),
    PUBLISHING("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission valueOfMission(String missionName) {
        return Arrays.stream(values())
                .filter(value -> missionName.equals(value.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 존재하지 않는 Mission 입니다."));
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public String getLevelMessage() {
        return level.getName();
    }

    public static boolean contains(String name) {
        return Arrays.stream(values())
                .anyMatch(value -> name.equals(value.getName()));
    }
}
