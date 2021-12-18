package pairmatching;

import java.util.ArrayList;
import java.util.List;

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
}
