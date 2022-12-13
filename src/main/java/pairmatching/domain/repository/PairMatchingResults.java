package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        System.out.println("added!");
    }

    public static boolean hasPreviousMatching(PairingOption pairingOption) {
        return pairMatchingResults.containsKey(pairingOption);
    }

    public static void deleteAll() {
        pairMatchingResults.clear();
    }

    public static boolean hasDuplicatedPairsInSameLevel(PairMatchingResult result) {
        List<Set<Crew>> pairsToCompare = new ArrayList<>(getPairsToCompare(result));
        List<Set<Crew>> newPairsFromResult = new ArrayList<>(result.getPairMatchingResult());
        pairsToCompare.retainAll(newPairsFromResult);
        return pairsToCompare.size() != 0;
    }

    private static List<Set<Crew>> getPairsToCompare(PairMatchingResult result) {
        Level level = result.getPairingOption().getLevel();
        List<PairingOption> optionsToCompare = getOptionsFromSameLevel(level);
        return getPairsInSameLevel(optionsToCompare);
    }

    private static List<PairingOption> getOptionsFromSameLevel(Level level) {
        return pairMatchingResults.keySet().stream()
                .filter(pairingOption -> pairingOption.getLevel() == level)
                .collect(Collectors.toList());
    }

    private static List<Set<Crew>> getPairsInSameLevel(List<PairingOption> optionsToCheck) {
        return optionsToCheck.stream()
                .map(option -> pairMatchingResults.get(option).getPairMatchingResult())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static PairMatchingResult searchByPairingOption(PairingOption pairingOption) {
        return pairMatchingResults.get(pairingOption);
    }
}
