package pairmatching.domain;

public enum ApplicationStatus {

    CREW_LOADING,
    PAIR_MATCHING,
    PAIR_SEARCHING,
    PAIR_INITIALIZING,
    APPLICATION_EXIT;

    public boolean isPlayable() {
        return this != APPLICATION_EXIT;
    }
}