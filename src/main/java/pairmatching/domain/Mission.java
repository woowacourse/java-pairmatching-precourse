package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
    RACING_GAME(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    NUMBER_BASEBALL_GAME(Level.LEVEL1, "숫자야구게임"),
    SHOPPING_BASKET(Level.LEVEL2, "장바구니"),
    PAYMENT(Level.LEVEL2, "결제"),
    SUBWAY_ROUTE_MAP(Level.LEVEL2, "지하철노선도"),
    IMPROVE_PERFORMANCE(Level.LEVEL4, "성능 개선"),
    DISTRIBUTION(Level.LEVEL4, "배포");

    private static final String MISSION_ERROR_MESSAGE = "[ERROR] 레벨에 포함되지 않는 미션이름을 입력하셨습니다.";

    private Level level;
    private String missionName;

    Mission(Level level, String missionName){
        this.level = level;
        this.missionName = missionName;
    }

    public static Mission ofValues(Level level, String missionName){
        return Arrays.stream(values())
                .filter(mission->mission.level.equals(level))
                .filter(mission->mission.missionName.equals(missionName))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(MISSION_ERROR_MESSAGE));
    }

}
