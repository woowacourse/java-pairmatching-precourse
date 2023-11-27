package pairmatching.domain.option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Mission {
    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    SHOPPING_CART("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4);

    private String name;
    private Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission findByName(String name) {
        for (Mission mission : Mission.values()) {
            if (mission.name.equals(name)) {
                return mission;
            }
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static List<Mission> findAll() {
        return new ArrayList<>(Arrays.asList(Mission.values()));
    }
}
