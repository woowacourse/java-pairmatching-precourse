package pairmatching.repository.matching;

import java.util.Set;
import pairmatching.domain.Pair;

public class MissionHistory {
    private Set<Pair> pairs;

    public MissionHistory(Set<Pair> pairs) {
        this.pairs = pairs;
    }

    public Set<Pair> getPairs() {
        return pairs;
    }
}
