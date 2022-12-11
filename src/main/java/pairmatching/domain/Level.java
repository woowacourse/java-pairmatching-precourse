package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    public static final String NOT_EXISTING_LEVEL_NAME = "존재하지 않는 레벨 이름";
    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level findByName(String levelName) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(levelName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTING_LEVEL_NAME));
    }

    // 추가 기능 구현

    @Override
    public String toString() {
        return "Level{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
