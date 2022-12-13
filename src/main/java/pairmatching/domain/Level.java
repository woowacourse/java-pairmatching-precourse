package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Level {

    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구나", "결제", "지하철노선도")),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", new ArrayList<>());

    private final String levelName;
    private final List<String> missions;

    Level(final String levelName, final List<String> missions) {
        this.levelName = levelName;
        this.missions = missions;
    }

    public static void validateLevelAndMission(String levelName, String mission) {
        Arrays.stream(values())
                .filter(level -> level.levelName.equals(levelName))
                .filter(level -> level.missions.contains(mission))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 미션 또는 레벨이 아닙니다. 다시 입력해 주세요."));
    }

    public static Level from(String levelName) {
        return Arrays.stream(values())
                .filter(level -> level.levelName.equals(levelName))
                .findFirst()
                .get();
    }
}
