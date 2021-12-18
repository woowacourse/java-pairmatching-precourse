package pairmatching;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5"),
    ;

    public static final List<String> levelNameList = Arrays.stream(Level.values())
            .map(Level::getLevelName)
            .collect(Collectors.toList());

    public static final Map<String, String> LEVEL_NAME_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Level::getLevelName, Level::name))
    );

    public static Level of(final String levelName) {
        if (!levelNameList.contains(levelName)) {
            throw new IllegalArgumentException("해당 이름의 level이 없습니다.");
        }

        return Level.valueOf(LEVEL_NAME_MAP.get(levelName));
    }

    private String levelName;

    Level(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }
}
