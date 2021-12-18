package pairmatching.exception;

public class MissionNotFoundException extends IllegalArgumentException {

    private static final String MISSION_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 존재하지 않는 미션입니다.";

    public MissionNotFoundException() {
        super(MISSION_NOT_FOUND_ERROR_MESSAGE);
    }
}
