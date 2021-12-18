package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

import pairmatching.util.Constant;

public class Pair {
    private List<Crew> pair;

    public Pair() {
        this.pair = new ArrayList<>();
    }

    public void addPair(Crew crew) {
        pair.add(crew);
    }

    @Override
    public String toString() {
        return String.join(Constant.PAIR_FORMAT, pair.toArray().toString());
    }
}
