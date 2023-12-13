package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.ExceptionMessage;

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

    public static Level from(String input) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                                ExceptionMessage.INVALID_MATCHING_CONDITIONS.getMessage()));
    }
}
