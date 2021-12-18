package pairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mission {
    private Level level;
    private String name;
    private List<Pair> pairs;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
        this.pairs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pair> getPairs() {
        return this.pairs;
    }

    public void addPairs(List<Pair> pairs) {
        this.pairs.addAll(pairs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mission)) {
            return false;
        }
        Mission mission = (Mission)o;
        return level == mission.level && Objects.equals(name, mission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, name);
    }

    public boolean equalTo(String name, Level level) {
        return this.name.equals(name) && this.level == level;
    }
}
