package pairmatching.repository;

import pairmatching.model.Level;
import pairmatching.model.Pair;
import pairmatching.system.exception.DuplicationPairsException;
import pairmatching.vo.PairMatchingInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingRepository {
    private final Map<PairMatchingInfo, List<Pair>> matchedPairs = new HashMap<>();

    public void save(PairMatchingInfo pairMatchingInfo, List<Pair> pairs) {
        matchedPairs.put(pairMatchingInfo, pairs);
    }

    public boolean hasDuplicatingAtSameLevel(PairMatchingInfo pairMatchingInfo, List<Pair> pairs) {
        List<List<Pair>> matchedPairsAtSameLevel = findAllByLevel(pairMatchingInfo.getLevel());

        try {
            checkHavingDuplicatingPairs(pairs, matchedPairsAtSameLevel);
        } catch (DuplicationPairsException e) {
            return true;
        }

        return false;
    }

    private static void checkHavingDuplicatingPairs(List<Pair> pairs, List<List<Pair>> matchedPairsAtSameLevel) throws DuplicationPairsException {
        for (List<Pair> pairsAtSameLevel : matchedPairsAtSameLevel) {
            checkDuplicationByEachPairMatchingInfo(pairs, pairsAtSameLevel);
        }
    }

    private static void checkDuplicationByEachPairMatchingInfo(List<Pair> pairs, List<Pair> pairsAtSameLevel) throws DuplicationPairsException {
        for (Pair pair : pairsAtSameLevel) {
            checkDuplication(pairs, pair);
        }
    }

    private static void checkDuplication(List<Pair> pairs, Pair pair) throws DuplicationPairsException {
        if (pairs.contains(pair)) {
            throw new DuplicationPairsException();
        }
    }

    private List<List<Pair>> findAllByLevel(Level level) {
        List<List<Pair>> matchedPairsAtSameLevel = new ArrayList<>();
        getPairsAtSameLevel(level, matchedPairsAtSameLevel);
        return matchedPairsAtSameLevel;
    }

    private void getPairsAtSameLevel(Level level, List<List<Pair>> matchedPairsAtSameLevel) {
        matchedPairs.forEach((pairMatchingInfo, pairs) -> {
            if (pairMatchingInfo.getLevel() == level) {
                matchedPairsAtSameLevel.add(pairs);
            }
        });
    }
}
