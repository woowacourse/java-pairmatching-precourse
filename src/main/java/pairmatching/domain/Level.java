package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Level getLevel(final String name) {
        return Arrays.stream(values())
            .filter(v -> v.name.equals(name))
            .findFirst()
            .orElseThrow(IllegalAccessError::new);
    }
}