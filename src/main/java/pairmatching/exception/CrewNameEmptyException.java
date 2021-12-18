package pairmatching.exception;

public class CrewNameEmptyException extends IllegalArgumentException {

    private static final String CREW_NAME_EMPTY_ERROR_MESSAGE = "[ERROR] 이름은 공백이 들어올 수 없습니다.";

    public CrewNameEmptyException() {
        super(CREW_NAME_EMPTY_ERROR_MESSAGE);
    }
}
