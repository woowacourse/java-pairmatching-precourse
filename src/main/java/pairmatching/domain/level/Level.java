package pairmatching.domain.level;

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

    // 추가 기능 구현
    public boolean isSameLevel(Level level) {
        return this.name.equals(level.name);
    }

    public String getName() {
        return name;
    }
}