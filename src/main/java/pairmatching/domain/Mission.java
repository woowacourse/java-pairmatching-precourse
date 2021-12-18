package pairmatching.domain;

import pairmatching.utils.ExceptionMessage;

import java.util.Arrays;

public enum Mission {
    LEVEL1(Level.LEVEL1, new String[] {"자동차경주", "로또", "숫자야구게임"}),
    LEVEL2(Level.LEVEL2, new String[] {"장바구니", "결제", "지하철노선도"}),
    LEVEL3(Level.LEVEL3, new String[] {}),
    LEVEL4(Level.LEVEL4, new String[] {"성능개선", "배포"}),
    LEVEL5(Level.LEVEL5, new String[] {});

    private Level level;
    private String[] missions;

    Mission(Level level, String[] missions) {
        this.level = level;
        this.missions = missions;
    }

    public Level getLevel() {
        return level;
    }

    public String[] getMissions() {
        return missions;
    }

    public static Mission existMission(Level level, String mission) {
        return Arrays.stream(Mission.values())
                .filter(value -> value.getLevel() == level
                        && Arrays.asList(value.getMissions()).contains(mission))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_INFORMATION_DATA));


    }
}
