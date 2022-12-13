package pairmatching.domain.repository;

import java.util.HashMap;
import java.util.Map;
import pairmatching.domain.PairMatchingResult;
import pairmatching.domain.option.PairingOption;

public class PairMatchingResults {
    private PairMatchingResults() {
    }

    private static final Map<PairingOption, PairMatchingResult> pairMatchingResults = new HashMap<>();

    public static void addCrew(PairingOption pairingOption, PairMatchingResult pairMatchingResult) {
        pairMatchingResults.put(pairingOption, pairMatchingResult);
    }

    public static boolean hasPreviousMatching(PairingOption pairingOption) {
        return pairMatchingResults.containsKey(pairingOption);
    }

    public static void deleteAll() {
        pairMatchingResults.clear();
    }
}
