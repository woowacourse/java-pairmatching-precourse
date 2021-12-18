package pairmatching.domain.mission;

import pairmatching.domain.Level;

public class Mission {
    private final Level level;
    private final String name;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }
}
