package pairmatching.domain.matcher;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.crew.Crew;

public class Pairs {
    private ArrayList<ArrayList<Crew>> pairs = new ArrayList<ArrayList<Crew>>();

    public void addPair(List<Crew> pair) {
        pairs.add((ArrayList<Crew>)pair);
    }

    public void deleteAll() {
        for (ArrayList<Crew> pair : pairs) {
            pair.clear();
        }
    }
}
