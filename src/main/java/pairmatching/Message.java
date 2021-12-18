package pairmatching;

public class Message {
    public static String INPUT_FUNCTIONS = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
    public static String ERROR_INPUT = "[ERROR} 잘못된 입력입니다.";
    public static String PRINT_COURSES = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" + "미션:\n" + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" + "  - 레벨3:\n" + "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5:\n" + "#############################################";
    public static String INPUT_COURSES = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
    public static String ALREADY_EXISTS = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    public static String RESULT_PAIR = "\n페어 매칭 결과입니다.";
}
