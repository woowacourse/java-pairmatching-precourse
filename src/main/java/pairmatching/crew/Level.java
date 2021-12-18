package pairmatching.crew;

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

    public static Level getLevelName(String name) {
        for(Level level : Level.values()) {
            if(level.name.equals(name))
                return level;
        }
        return null;
    }
}
