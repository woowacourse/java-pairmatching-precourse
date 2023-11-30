package pairmatching.view.constant;

public enum OutputMessage {
    DISPLAY_PROCESS("\n#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "\t- 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "\t- 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "\t- 레벨3:\n"
            + "\t- 레벨4: 성능개선 | 배포\n"
            + "\t- 레벨5:\n"
            + "############################################"),
    RESPONSE_PAIR_MATCHING("페어 매칭 결과입니다."),
    RESPONSE_INITIALRIZE("초기화 되었습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
