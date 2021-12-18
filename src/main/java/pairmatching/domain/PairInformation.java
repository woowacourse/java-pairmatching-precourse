package pairmatching.domain;

import java.util.List;

public class PairInformation {
    private final PairMission pairMission;
    private final List<Pair> pairs;

    public PairInformation(PairMission pairMission, List<Pair> pairs) {
        this.pairMission = pairMission;
        this.pairs = pairs;
    }
}