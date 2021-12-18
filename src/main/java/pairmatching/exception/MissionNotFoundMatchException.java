package pairmatching.exception;

public class MissionNotFoundMatchException extends RuntimeException {

    private static final String MISSION_NOT_FOUNT_MATCH_ERROR_MESSAGE = "[ERROR] 종료되지 않아 페어를 확인할 수 없습니다.";

    public MissionNotFoundMatchException() {
        super(MISSION_NOT_FOUNT_MATCH_ERROR_MESSAGE);
    }
}
