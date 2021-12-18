package pairmatching.domain.pairMatcher;

import java.util.ArrayList;

public class PairList {
    ArrayList<Pair> pairList = new ArrayList<>();

    public void addPair(Pair pair) {
        pairList.add(pair);
    }
}
