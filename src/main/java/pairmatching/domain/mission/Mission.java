package pairmatching.domain.mission;

import pairmatching.domain.Level;

public class Mission {
    private final Level level;
    private final String name;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "level=" + level +
                ", name='" + name + '\'' +
                '}';
    }
}
