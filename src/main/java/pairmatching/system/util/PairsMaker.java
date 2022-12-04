package pairmatching.system.util;

import pairmatching.model.Crew;
import pairmatching.model.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsMaker {
    public List<Pair> makePairs(List<Crew> crews) {
        ArrayList<Pair> pairs = new ArrayList<>();
        while (2 <= crews.size()) {
            List<Crew> matchedCrews = getMatchedCrews(crews);
            pairs.add(new Pair(matchedCrews));
        }
        return pairs;
    }

    private static List<Crew> getMatchedCrews(List<Crew> crews) {
        List<Crew> matchedCrews = new ArrayList<>(Arrays.asList(crews.remove(0), crews.remove(0)));
        handleOddCrewSizeCase(crews, matchedCrews);
        return matchedCrews;
    }

    private static void handleOddCrewSizeCase(List<Crew> crews, List<Crew> matchedCrews) {
        if (crews.size() == 1) {
            matchedCrews.add(crews.remove(0));
        }
    }
}
