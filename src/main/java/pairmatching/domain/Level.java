package pairmatching.domain;

public enum Level {
    LEVEL1("레벨1", 1),
    LEVEL2("레벨2", 2),
    LEVEL3("레벨3", 3),
    LEVEL4("레벨4", 4),
    LEVEL5("레벨5", 5);

    private String name;
    private int level;

    Level(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public boolean isSameLevel(int level) {
        return this.level == level;
    }
}
