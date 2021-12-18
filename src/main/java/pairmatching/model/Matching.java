package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.crew.Crew;

public class Matching {
    private static final String SPACE = " ";
    private static final String COLON = ":";

    private final List<String> crewNames;

    public Matching(final List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public List<Crew> makePair() {
        final List<Crew> pairs = new ArrayList<>();

        return pairs;
    }


}
