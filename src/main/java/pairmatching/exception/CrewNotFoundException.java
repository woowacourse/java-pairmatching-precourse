package pairmatching.exception;

public class CrewNotFoundException extends IllegalArgumentException {

    private static final String CREW_NOT_FOUND_ERROR_MESSAGE ="[ERROR] 존재하지 않는 크루입니다.";

    public CrewNotFoundException() {
        super(CREW_NOT_FOUND_ERROR_MESSAGE);
    }
}
