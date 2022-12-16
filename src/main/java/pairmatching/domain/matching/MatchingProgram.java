package pairmatching.domain.matching;

import pairmatching.domain.choice.Choice;
import pairmatching.domain.crew.Crew;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class MatchingProgram {

    private static final int MINIMUM_COUNT = 0;
    private static final int MAXIMUM_COUNT = 3;
    private static final String ERROR_MESSAGE = "[ERROR] 매칭 시도가 %d회를 초과하였습니다.";
    private final MatchingHistory history;
    private final PairMatchingMachine pairMatchingMachine;

    public MatchingProgram(MatchingHistory history, PairMatchingMachine pairMatchingMachine) {
        this.history = history;
        this.pairMatchingMachine = pairMatchingMachine;
    }

    public boolean hasMatched(Choice choice) {
        return history.hasMatchingOf(choice);
    }

    public List<Set<Crew>> matchAndRecord(Choice choice) throws IOException {
        List<Set<Crew>> pairs;
        int count = MINIMUM_COUNT;
        do {
            pairs = pairMatchingMachine.makePairs(choice);
            count++;
            if (count == MAXIMUM_COUNT) {
                throw new IllegalStateException(String.format(ERROR_MESSAGE, count));
            }
        } while (!history.hasDuplicatePairInSameLevel(choice, pairs));
        return pairs;
    }
}
