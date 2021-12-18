package pairmatching.model.information;

public enum ProgramFunction {
    PAIR_MATCHING("1. 페어 매칭"),
    PAIR_SEARCHING("2. 페어 조회"),
    PAIR_INITIALIZING("3. 페어 초기화"),
    PROGRAM_TERMINATE("Q. 종료");

    private final String signal;

    ProgramFunction(final String signal) {
        this.signal = signal;
    }

    public String getSignal() {
        return signal;
    }

}
