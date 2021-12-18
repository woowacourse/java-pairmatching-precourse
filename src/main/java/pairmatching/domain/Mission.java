package pairmatching.domain;

import java.util.Arrays;

public class Mission {
    Level level;
    MissionName name;

    public Mission(String name, int level) {
        this.name = Arrays.stream(MissionName.values())
                .filter(m -> m.isSameName(name))
                .findFirst()
                .orElse(null);
        this.level = Arrays.stream(Level.values())
                .filter(l -> l.isSameLevel(level))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return this.name.getName();
    }

    public boolean isSameName(String name) {
        return this.name.isSameName(name);
    }

    @Override
    public String toString() {
        return "Mission{" +
                "level=" + level +
                ", name=" + name +
                '}';
    }
}
