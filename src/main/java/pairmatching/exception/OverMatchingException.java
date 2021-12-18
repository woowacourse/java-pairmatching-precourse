package pairmatching.exception;

public class OverMatchingException extends RuntimeException {

    private static final String OVER_MATCHING_ERROR_MESSAGE = "[ERROR] 3번 이상 Matching 이 실패했습니다.";

    public OverMatchingException() {
        super(OVER_MATCHING_ERROR_MESSAGE);
    }
}
