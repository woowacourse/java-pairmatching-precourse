package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mission {
    Level level;
    MissionName name;
    List<Pair> pairs;

    public Mission(String name, int level) {
        this.name = Arrays.stream(MissionName.values())
                .filter(m -> m.isSameName(name))
                .findFirst()
                .orElse(null);
        this.level = Arrays.stream(Level.values())
                .filter(l -> l.isSameLevel(level))
                .findFirst()
                .orElse(null);
        pairs = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Mission{" +
                "level=" + level +
                ", name=" + name +
                ", pairs=" + pairs +
                '}';
    }
}
