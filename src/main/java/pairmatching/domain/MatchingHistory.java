package pairmatching.domain;

import pairmatching.domain.choice.Choice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatchingHistory {

    private final Map<Choice, Set<Crew>> history;

    public MatchingHistory() {
        this.history = new HashMap<Choice, Set<Crew>>();
    }

    public boolean hasMatchingOf(Choice choice) {
        return history.containsKey(choice);
    }
}
