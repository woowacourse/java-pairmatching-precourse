package pairmatching;

import java.util.Arrays;
import pairmatching.exception.ErrorMessage;

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

    public static Level findByLevel(String name) {
        return Arrays.stream(Level.values())
            .filter(level -> level.name.equals(name))
            .findAny()
            .orElseThrow(ErrorMessage.NOT_FOUND_LEVEL::getException);
    }
}
