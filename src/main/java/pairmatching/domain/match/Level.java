package pairmatching.domain.match;

import java.util.Arrays;

import static pairmatching.util.Validator.ERROR_PREFIX;

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

    public static Level checkExistLevel(String name) {
        return Arrays.stream(values())
                .filter(level -> name.equals(level.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 레벨입니다."));
    }
}
