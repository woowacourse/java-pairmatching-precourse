package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.dto.PairDto;

public class BackPairs {
    private Level level;
    private Mission mission;
    private final List<Pair> pairs = new ArrayList<>();

    public BackPairs(String mission, String level) {
        this.mission = Mission.findBy(mission);
        this.level = Level.findBy(level);
    }

    public void addPair(PairDto pairDto) {
        pairs.add(new Pair(pairDto));
    }
    public List<Pair> pairs() {
        return pairs;
    }
}
