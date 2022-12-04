package pairmatching.system.util;

import pairmatching.model.Crew;
import pairmatching.model.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsMaker {
    public List<Pair> makePairs(List<String> crewNames) {
        ArrayList<Pair> pairs = new ArrayList<>();
        List<String> modifiableCrews = new ArrayList<>(crewNames);
        while (2 <= modifiableCrews.size()) {
            List<String> matchedCrews = getMatchedCrews(modifiableCrews);
            pairs.add(new Pair(matchedCrews));
        }
        return pairs;
    }

    private static List<String> getMatchedCrews(List<String> crewNames) {
        List<String> matchedCrews = Arrays.asList(
                crewNames.remove(0), crewNames.remove(0)
        );

        handleOddCrewSizeCase(crewNames, matchedCrews);
        return matchedCrews;
    }

    private static void handleOddCrewSizeCase(List<String> crews, List<String> matchedCrews) {
        if (crews.size() == 1) {
            matchedCrews.add(crews.remove(0));
        }
    }
}
