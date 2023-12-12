package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.ExceptionMessage;

public enum Mission {
    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL_GAME("숫자야구게임", Level.LEVEL1),

    SHOPPING_BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_MAP("지하철노선도", Level.LEVEL2),

    PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission from(String input) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ExceptionMessage.INVALID_MATCHING_REQUEST.getMessage()));
    }
}
