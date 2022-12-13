package pairmatching.domain.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.PairMatchingResult;
import pairmatching.domain.option.PairingOption;

public class PairMatchingResults {
    private PairMatchingResults() {
    }

    private static final Map<PairingOption, PairMatchingResult> pairMatchingResults = new HashMap<>();

    public static void addPairMatchingResult(PairingOption pairingOption, PairMatchingResult pairMatchingResult) {
        pairMatchingResults.put(pairingOption, pairMatchingResult);
    }

    public static boolean hasPreviousMatching(PairingOption pairingOption) {
        return pairMatchingResults.containsKey(pairingOption);
    }

    public static void deleteAll() {
        pairMatchingResults.clear();
    }

    public static boolean hasDuplicatedPairsInSameLevel(PairMatchingResult result) {
        Level level = result.getPairingOption().getLevel();
        List<PairingOption> optionsToCheck = getOptionsFromSameLevel(level);
        List<List<Crew>> pairsInSameLevel = getPairsInSameLevel(optionsToCheck);
        List<List<Crew>> newPairsFromResult = result.getPairMatchingResult();
        return pairsInSameLevel.retainAll(newPairsFromResult);
    }

    private static List<PairingOption> getOptionsFromSameLevel(Level level) {
        return pairMatchingResults.keySet().stream()
                .filter(pairingOption -> pairingOption.getLevel() == level)
                .collect(Collectors.toList());
    }

    private static List<List<Crew>> getPairsInSameLevel(List<PairingOption> optionsToCheck) {
        return optionsToCheck.stream()
                .map(option -> pairMatchingResults.get(option).getPairMatchingResult())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
