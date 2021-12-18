package pairmatching.enums;

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

    public String getName() {
        return this.name;
    }

    // 추가 기능 구현
    public static Level findByName(String name) {
        for(Level level : Level.values()) {
            if(level.getName().equals(name)) {
                return level;
            }
        }
        throw new IllegalArgumentException("[ERROR] 레벨 이름을 찾을 수 없습니다.");
    }
}
