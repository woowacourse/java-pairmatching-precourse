package pairmatching.domain.mission;

import pairmatching.domain.Level;

public class Mission {
    private Level level;
    private String name;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equal(Level level, String name) {
        return this.name.equals(name) && this.level.equals(level);
    }
}
