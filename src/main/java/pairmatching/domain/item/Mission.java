package pairmatching.domain.item;

import java.util.Arrays;

public enum Mission {
    CAR_RACING("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    NUMBER_BASEBALL("숫자야구게임", Level.LEVEL1),
    SHOPPING_BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_MAP("지하철노선도", Level.LEVEL2),
    PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL3),
    PUBLISHING("배포", Level.LEVEL3);

    private static final String DISCORDANCE_ERROR_MESSAGE = "[ERROR] %s 미션은 \"%s\"이 아닙니다.";
    private static final String VALUE_ERROR_MESSAGE = "[ERROR] %s 미션은 존재하지 않습니다.";
    private final String missionName;
    private final Level level;

    Mission(String missionName, Level level) {
        this.missionName = missionName;
        this.level = level;
    }

    public static Mission valueOfMissionAndLevel(String missionName, Level level) {
        Mission mission = valueOfMission(missionName);
        if (level.equals(mission.getLevel())) {
            throw new IllegalArgumentException(String.format(DISCORDANCE_ERROR_MESSAGE, missionName, level.getLevelName()));
        }
        return mission;
    }

    public static Mission valueOfMission(String name) {
        return Arrays.stream(values())
                .filter(value -> name.equals(value.getMissionName()))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(String.format(VALUE_ERROR_MESSAGE, name)));
    }

    public String getMissionName() {
        return missionName;
    }

    public Level getLevel() {
        return level;
    }

    public boolean isSameLevel(Mission mission) {
        return level.equals(mission.getLevel());
    }
}
