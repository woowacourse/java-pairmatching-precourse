package pairmatching.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", null),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", null);

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }

    public static boolean isContainedLevel(String name) {
        return Arrays.stream(Level.values())
                .anyMatch(level -> level.getName().equals(name));
    }

    public static boolean isContainedMission(String name, String mission) {
        return Objects.requireNonNull(Arrays.stream(Level.values())
                        .filter(level -> level.getName().equals(name))
                        .findFirst()
                        .orElse(null))
                .getMissions()
                .contains(mission);
    }

    public static Level findNameByValue(String value) {
        return Arrays.stream(Level.values())
                .filter(level -> level.getName().equals(value))
                .findFirst()
                .orElse(null);
    }
}