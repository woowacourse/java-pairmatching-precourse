package pairmatching.domain.program;

import pairmatching.domain.MatchingHistory;
import pairmatching.domain.MatchingMachine;
import pairmatching.domain.choice.Choice;

public class PairMatchingProgram {

    private final MatchingHistory history;
    private final MatchingMachine machine;

    public PairMatchingProgram(MatchingHistory history, MatchingMachine machine) {
        this.history = history;
        this.machine = machine;
    }

    public boolean hasMatched(Choice choice) {
        return history.hasMatchingOf(choice);
    }
}
