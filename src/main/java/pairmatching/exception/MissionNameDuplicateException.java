package pairmatching.exception;

public class MissionNameDuplicateException extends IllegalArgumentException {

    private static final String MISSION_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 동일한 이름의 미션이 저장될 수 없습니다.";

    public MissionNameDuplicateException() {
        super(MISSION_NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
