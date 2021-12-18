package pairmatching.domain;

import java.util.Collections;
import java.util.List;

public class PairInformation {
    private final PairMission pairMission;
    private final List<Pair> pairs;

    public PairInformation(PairMission pairMission, List<Pair> pairs) {
        this.pairMission = pairMission;
        this.pairs = pairs;
    }

    public PairMission getPairMission() {
        return pairMission;
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }

    public boolean isSamePairMission(PairMission pairMission) {
        return this.pairMission.equals(pairMission);
    }

    public boolean isSamePair(PairInformation pairInformation) {
        List<Pair> pairs = pairInformation.pairs;
        boolean result = false;
        for (Pair pair : this.pairs) {
            for (Pair otherPair : pairs) {
                result = containsCrew(pair, otherPair);
            }
        }

        return result;
    }

    private boolean containsCrew(Pair pair, Pair otherPair) {
        return pair.containsCrew(otherPair);
    }
}