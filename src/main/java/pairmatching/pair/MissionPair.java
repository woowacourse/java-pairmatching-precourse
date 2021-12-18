package pairmatching.pair;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.print.PaperSource;
import pairmatching.crew.Crew;
import pairmatching.crew.Position;
import pairmatching.mission.Mission;

public abstract class MissionPair {

    protected static final String ERR_DUPLICATED_PAIR = "매칭된 페어가 있습니다.";
    protected final Set<Pair> pairs = new HashSet<>();
    protected final Position position;
    protected final Mission mission;

    public MissionPair(Mission mission, Position position) {
        this.position = position;
        this.mission = mission;
    }

    public void addPair(List<Crew> crews) throws IllegalArgumentException {
        Pair pair = new Pair(this.position, crews);
        validateDuplicated(pair);
        this.pairs.add(pair);
    }

    public void addPair(Pair pair) {
        validateDuplicated(pair);
        this.pairs.add(pair);
    }

    public boolean hasPair(Pair pair) {
        return this.pairs.contains(pair);
    }

    public void validateDuplicated(Pair pair) {
        if (hasPair(pair)) {
            throw new IllegalArgumentException(ERR_DUPLICATED_PAIR);
        }
    }

    public Set<Pair> pairs() {
        return Collections.unmodifiableSet(pairs);
    }
}
