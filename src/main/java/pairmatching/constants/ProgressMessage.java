package pairmatching.constants;

public enum ProgressMessage {
    START_CHOICE("기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료"),
    LINE("\n"),
    COURSE_INFO("\n#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3:\n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5:\n"
            + "############################################"),
    RETRY_COURSE_CHECK("\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오"),

    CHOOSE_COURSE("과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주\n"
            + "프론트엔드, 레벨1, 자동차경주"),
    PAIR_MATCHING_RESULT("\n페어 매칭 결과입니다."),
    DELETE_MATCHING_RESULT("\n초기화 되었습니다.\n");
    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
