package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.exception.ExceptionMessage;

public class MatchingRepository {

    private List<Pairs> matchingRepository;

    public MatchingRepository() {
        this.matchingRepository = new ArrayList<>();
    }

    public void add(Pairs pairs) {
        matchingRepository.add(pairs);
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
