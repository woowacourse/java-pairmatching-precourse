package pairmatching.model.crew;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(final String name) {
        this.name = name;
    }

    public static Level of(final String name) {
        checkThreeAndFive(name);
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("레벨 입력이 잘못되었습니다."));
    }

    private static void checkThreeAndFive(final String name) {
        if (name.equals(LEVEL3.name) || name.equals(LEVEL5.name)) {
            throw new IllegalArgumentException("레벨 3과 레벨 5는 미션이 없습니다.");
        }
    }

}