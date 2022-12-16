package pairmatching.domain.matching;

import pairmatching.domain.choice.Choice;
import pairmatching.domain.crew.Crew;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class MatchingProgram {

    private static final int MINIMUM_COUNT = 0;
    private static final int MAXIMUM_COUNT = 3;
    private static final String UN_MATCHED_ERROR_MESSAGE = "[ERROR] 매칭 시도가 %d회를 초과하였습니다.\n";
    private static final String UN_MATCHED_CHOICE_ERROR_MESSAGE = "[ERROR] 매칭 이력이 없습니다.\n";
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
            validateMatchingCount(count);
        } while (!history.hasDuplicatePairInSameLevel(choice, pairs));
        history.record(choice, pairs);
        return pairs;
    }

    private void validateMatchingCount(int count) {
        if (count == MAXIMUM_COUNT) {
            throw new IllegalStateException(String.format(UN_MATCHED_ERROR_MESSAGE, count));
        }
    }

    public void deleteHistory(Choice choice) {
        history.delete(choice);
    }

    public List<Set<Crew>> show(Choice choice) {
        validate(choice);
        return history.getRecord(choice);
    }

    private void validate(Choice choice) {
        if (!hasMatched(choice)) {
            throw new IllegalArgumentException(UN_MATCHED_CHOICE_ERROR_MESSAGE);
        }
    }

    public void truncateHistory() {
        history.truncate();
    }
}
