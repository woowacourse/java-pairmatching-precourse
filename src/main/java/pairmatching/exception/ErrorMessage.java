package pairmatching.exception;

public enum ErrorMessage {
    NOT_FOUND_FILE(new IllegalArgumentException("[ERROR] 파일을 찾을 수 없습니다.")),
    NOT_FOUND_COMMAND(new IllegalArgumentException("[ERROR] 존재하지 않는 기능 선택입니다.")),
    NOT_FOUND_COURSE(new IllegalArgumentException("[ERROR] 존재하지 않는 과정입니다.")),
    NOT_FOUND_LEVEL(new IllegalArgumentException("[ERROR] 존재하지 레벨입니다.")),
    NOT_FOUND_MISSION(new IllegalArgumentException("[ERROR] 존재하지 않는 미션입니다.")),
    NOT_FOUND_PAIR(new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.")),
    NOT_SHUFFLE(new IllegalArgumentException("[ERROR] 매칭에 실패했습니다"));

    private final IllegalArgumentException exception;

    ErrorMessage(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}
