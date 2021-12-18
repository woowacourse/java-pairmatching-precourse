package pairmatching.mission;

public class Mission {

    private final Level level;
    private final String name;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
