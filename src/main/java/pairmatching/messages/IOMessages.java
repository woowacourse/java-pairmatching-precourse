package pairmatching.messages;

public enum IOMessages {

    COURSE("과정"),
    LEVEL("레벨"),
    MISSION("미션"),
    INPUT_SELECT_OPTIONS(
            String.format("%s, %s, %s을 선택하세요.", COURSE.getMessage(), LEVEL.getMessage(), MISSION.getMessage())),
    SELECT_EXAMPLE("ex) 백엔드, 레벨1, 자동차경주"),
    INPUT_FUNCTION("기능을 선택하세요."),
    INPUT_REMATCHING("매칭 정보가 있습니다. 다시 매칭하시겠습니까?"),
    OUTPUT_DIVIDING_LINE("#############################################"),
    OUTPUT_PAIRMATCHING_RESULT("페어 매칭 결과입니다."),
    OUTPUT_RESET("초기화 되었습니다.");


    private final String message;

    IOMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
