package pairmatching.domain.item;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String ERROR_MESSAGE = "[ERROR] %s 레벨은 존재하지 않습니다.";
    private String levelName;

    Level(String levelName) {
        this.levelName = levelName;
    }

    public static Level valueOfLevel(String name) {
        return Arrays.stream(values())
                .filter(value -> name.equals(value.getLevelName()))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(String.format(ERROR_MESSAGE, name)));
    }

    public String getLevelName() {
        return levelName;
    }
}
