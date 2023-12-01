package pairmatching.constants;

public enum ErrorMessage {
    INPUT_CHOICE_ERROR("1, 2, 3, Q 중에 입력해주세요."),
    NO_MATCHING_ERROR("매칭 정보가 없습니다."),
    INPUT_FORMAT_ERROR("입력 형식이 잘못되었습니다."),
    INPUT_NO_VALUE("입력값이 없습니다."),
    INVALID_POSITION_ERROR("백엔드, 프론트엔드 중에 입력해주세요."),
    INVALID_LEVEL_ERROR(" 레벨1, 레벨2, 레벨3, 레벨4, 레벨5 중에 입력해주세요."),
    INVALID_MISSION_ERROR("현재 %s은 미션을 지원하지 않습니다."),
    INVALID_LEVEL_MISSION_ERROR("%s의 미션중에서 입력해주세요."),
    INPUT_RETRY_ERROR("네, 아니오 중에 입력해주세요."),
    MATCHING_ERROR("매칭에 실패하였습니다."),
    FILE_READER_ERROR("파일을 읽을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
