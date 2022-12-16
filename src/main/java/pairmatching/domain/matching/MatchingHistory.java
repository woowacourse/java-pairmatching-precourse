package pairmatching.domain.matching;

import pairmatching.domain.choice.Choice;
import pairmatching.domain.crew.Crew;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatchingHistory {

    private final Map<Choice, Set<Crew>> history;

    public MatchingHistory() {
        this.history = new HashMap<>();
    }

    public boolean hasMatchingOf(Choice choice) {
        return history.containsKey(choice);
    }
}
