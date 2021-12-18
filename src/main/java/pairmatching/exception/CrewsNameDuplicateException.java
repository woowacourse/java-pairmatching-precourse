package pairmatching.exception;

public class CrewsNameDuplicateException extends IllegalArgumentException {

    private static final String CREW_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 크루의 이름이 중복될 수 없습니다.";

    public CrewsNameDuplicateException() {
        super(CREW_NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
