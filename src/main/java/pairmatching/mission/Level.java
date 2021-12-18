package pairmatching.mission;

import java.util.Arrays;

public enum Level {

    LEVEL1("레벨1", 1),
    LEVEL2("레벨2", 2),
    LEVEL3("레벨3", 3),
    LEVEL4("레벨4", 4),
    LEVEL5("레벨5", 5);

    private static final String NO_LEVEL = "1~5까지만 가능합니다.";
    private final String name;
    private final int level;

    Level(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public Level of(int level) {
        return Arrays.stream(Level.values())
            .filter(l -> l.level == level)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NO_LEVEL));
    }
}
