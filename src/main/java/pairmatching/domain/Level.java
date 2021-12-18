package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import pairmatching.exception.LevelNotFoundException;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static List<Level> levels() {
        return Arrays.asList(values().clone());
    }

    public static Level getLevel(String name) {
        return Arrays.stream(values())
            .filter(level -> level.name.equals(name))
            .findFirst()
            .orElseThrow(LevelNotFoundException::new);
    }

    public String getName() {
        return name;
    }
}
