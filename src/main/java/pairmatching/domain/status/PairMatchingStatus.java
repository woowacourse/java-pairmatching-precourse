package pairmatching.domain.status;

public enum PairMatchingStatus {
    SELECT_PAIRING_OPTION,
    HANDLE_PREVIOUS_MATCHING,
    ATTEMPT_MATCHING,
    HANDLE_DUPLICATED_PAIRS,
    SUCCESS_MATCHING,
    FAIL_MATCHING;

    public boolean continuePairMatching() {
        return this != SUCCESS_MATCHING && this != FAIL_MATCHING;
    }
}
