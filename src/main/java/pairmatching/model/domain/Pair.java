package pairmatching.model.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.domain.Crew;
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
        ArrayList<String> names = new ArrayList<>();
        for (Crew crew : pair) {
            names.add(crew.toString());
        }
        return String.join(Constant.PAIR_FORMAT, names);
    }
}
