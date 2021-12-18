package pairmatching.util;

public class Message {

    private Message() {
    }

    public static final String MENU_GUIDE = "기능을 선택하세요.\n"
        + "1. 페어 매칭\n"
        + "2. 페어 조회\n"
        + "3. 페어 초기화\n"
        + "Q. 종료";
    public static final String COURSE_LEVEL_PROCESS = "#############################################\n"
        + "과정: 백엔드 | 프론트엔드\n"
        + "미션:\n"
        + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
        + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
        + "  - 레벨3: \n"
        + "  - 레벨4: 성능개선 | 배포\n"
        + "  - 레벨5: \n"
        + "############################################\n"
        + "과정, 레벨, 미션을 선택하세요.\n"
        + "ex) 백엔드, 레벨1, 자동차경주";
    public static final String ERROR = "[ERROR]";
    public static final String OPTIONS_ERROR = "코스, 레벨, 미션 모두 정확하게 입력 해야합니다. ";
    public static final String MENU_ERROR = "기능 선택 종류에 있는 것만 선택 가능합니다.";
    public static final String LEVEL_ERROR = "레벨 종류에 있는 것만 선택 가능합니다.";
    public static final String COURSE_ERROR = "코스 종류에 있는 것만 선택 가능합니다.";
    public static final String MISSION_ERROR = "미션 종류에 있는 것만 선택 가능합니다.";
    public static final String RESULT_PRINT = "페어 매칭 결과입니다.";
}
