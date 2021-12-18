package pairmatching.view;

public class OutputView {

    private static final String ERROR_SYMBOL = "[ERROR] ";
    private static final String COURSE_LENEL_MISSION_INFO = "#############################################\n"
        + "과정: 백엔드 | 프론트엔드\n"
        + "미션:\n"
        + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
        + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
        + "  - 레벨3: \n"
        + "  - 레벨4: 성능개선 | 배포\n"
        + "  - 레벨5: \n"
        + "############################################";

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

    public static void printCourseLevelMissionInfo() {
        System.out.println(COURSE_LENEL_MISSION_INFO);
    }
}
