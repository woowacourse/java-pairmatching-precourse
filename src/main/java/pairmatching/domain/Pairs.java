package pairmatching.domain;

import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {
    private final static int FIRST_INDEX = 0;

    private List<Pair> pairList = new ArrayList<>();

    public List<Pair> getPairList() {
        return Collections.unmodifiableList(pairList);
    }

    public void addPair(Pair pair) {
        pairList.add(pair);
    }

    public void addLastMember(Crew crew) {
        int lastIndex = pairList.size() - 1;
        Pair pair = pairList.get(lastIndex);
        pair.addCrew(crew);

        pairList.remove(lastIndex);
        pairList.add(pair);
    }

    public void removeAll() {
        int size = pairList.size();
        for (int i = 0; i < size; i++) {
            pairList.remove(FIRST_INDEX);
        }
    }

    @Override
    public String toString() {
        return pairList.toString();
    }
}
