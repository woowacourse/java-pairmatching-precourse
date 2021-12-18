package pairmatching.domain;

import java.util.List;

public class PairHistory {
    private final Level level;
    private final List<Crew> pairs;

    public PairHistory(List<Crew> pairs, Level level) {
        this.pairs = pairs;
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public List<Crew> getPairs() {
        return pairs;
    }
}
