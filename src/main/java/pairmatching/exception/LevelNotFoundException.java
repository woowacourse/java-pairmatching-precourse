package pairmatching.exception;

public class LevelNotFoundException extends IllegalArgumentException {

    private static final String LEVEL_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 존재하지 않는 레벨입니다.";

    public LevelNotFoundException() {
        super(LEVEL_NOT_FOUND_ERROR_MESSAGE);
    }
}
