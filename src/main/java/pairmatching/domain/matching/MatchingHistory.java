package pairmatching.domain.matching;

import pairmatching.domain.choice.Choice;
import pairmatching.domain.crew.Crew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class MatchingHistory {
    private final Map<Choice, List<Set<Crew>>> history;

    public MatchingHistory() {
        this.history = new HashMap<>();
    }

    public boolean hasMatchingOf(Choice choice) {
        return history.containsKey(choice);
    }

    public void record(Choice choice, List<Set<Crew>> pairs) {
        history.put(choice, pairs);
    }

    public boolean hasDuplicatePairInSameLevel(Choice choice, List<Set<Crew>> pairs) {
        return history.keySet().stream()
                .filter(pastChoice -> pastChoice.hasSameLevel(choice))
                .noneMatch(pastChoice -> hasSamePair(pastChoice, pairs));
    }

    private boolean hasSamePair(Choice choice, List<Set<Crew>> pairs) {
        List<Set<Crew>> pastPairs = history.get(choice);
        return pastPairs.stream()
                .noneMatch(pair -> pairs.stream()
                        .anyMatch(Predicate.isEqual(pair)));
    }

    public void delete(Choice choice) {
        history.remove(choice);
    }

    public List<Set<Crew>> getRecord(Choice choice) {
        return history.get(choice);
    }

    public void truncate() {
        history.clear();
    }
}
