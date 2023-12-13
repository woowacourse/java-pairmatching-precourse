package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.exception.ExceptionMessage;

public class MatchingRepository {

    private List<Pairs> matchingRepository;

    public MatchingRepository() {
        this.matchingRepository = new ArrayList<>();
    }

    public void add(Pairs pairs) {
        matchingRepository.add(pairs);
    }

    public boolean hasPairs(MatchingConditions conditions, Pairs makePairs) {
        List<Pairs> sameLevelPairs = matchingRepository.stream()
                .filter(pairs -> pairs.getMatchingConditions().getLevel() == conditions.getLevel())
                .collect(Collectors.toList());

        for (Pairs sameLevel : sameLevelPairs) {
            if (checkPair(makePairs, sameLevel)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPair(Pairs makePairs, Pairs sameLevel) {
        for (Pair pair : sameLevel.getPairs()) {
            if (hasPair(makePairs, pair)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPair(Pairs makePairs, Pair pair) {
        for (Pair makePair : makePairs.getPairs()) {
            boolean result = pair.isCrews(makePair);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public Pairs search(MatchingConditions conditions) {
        return matchingRepository.stream()
                .filter(pairs -> pairs.getMatchingConditions().equals(conditions))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ExceptionMessage.NON_EXISTENT_HISTORY.getMessage()));
    }

    public boolean hasConditionsPair(MatchingConditions conditions) {
        return matchingRepository.stream()
                .noneMatch(pairs -> pairs.getMatchingConditions().equals(conditions));
    }

    public void reset() {
        matchingRepository = new ArrayList<>();
    }
}
