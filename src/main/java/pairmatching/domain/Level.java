package pairmatching.domain;

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

    public static Level getLevelFromInput(String input) {
        Level level = Level.findBy(input);

        if (level == null) {
            throw new IllegalArgumentException("[ERROR] 잘못된 레벨을 입력하셨습니다.");
        }

        return level;
    }

    private static Level findBy(String arg) {
        for (Level level : values()) {
            if (level.name().equals(arg)) {
                return level;
            }
        }

        return null;
    }
}
