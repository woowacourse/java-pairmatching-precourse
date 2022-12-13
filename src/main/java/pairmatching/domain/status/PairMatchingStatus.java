package pairmatching.domain.status;

public enum PairMatchingStatus {
    SELECT_PAIRING_OPTION,
    HANDLE_PREVIOUS_MATCHING,
    ATTEMPT_MATCHING,
    HANDLE_DUPLICATED_PAIRS,
    SUCCESS_MATCHING,
    FAIL_MATCHING,
    EXIT_PAIR_MATCHING;

    public boolean continuePairMatching() {
        return this != EXIT_PAIR_MATCHING;
    }
}
