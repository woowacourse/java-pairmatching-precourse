package pairmatching.view;

import java.util.List;

import pairmatching.domain.MatchingInfo;

public class OutputView {

    private static final String ERROR_SYMBOL = "[ERROR] ";
    private static final String COLON_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";
    private static final String COURSE_LENEL_MISSION_INFO = "#############################################\n"
        + "과정: 백엔드 | 프론트엔드\n"
        + "미션:\n"
        + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
        + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
        + "  - 레벨3: \n"
        + "  - 레벨4: 성능개선 | 배포\n"
        + "  - 레벨5: \n"
        + "############################################";
    private static final String MATCHING_RESULT_INFO_MESSAGE = "페어 매칭 결과입니다.";
    private static final String INITIALIZATION_INFO_MESSAGE = "초기화 되었습니다.";

    public static void printMessage(final String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(final String errorMessage) {
        printNewLine();
        System.out.println(ERROR_SYMBOL + errorMessage);
        printNewLine();
    }

    public static void printCourseLevelMissionInfo() {
        System.out.println(COURSE_LENEL_MISSION_INFO);
    }

    public static void printPairs(final MatchingInfo matchingInfo) {
        System.out.println(MATCHING_RESULT_INFO_MESSAGE);
        for (List<String> pair : matchingInfo.getPairList()) {
            System.out.println(String.join(COLON_DELIMITER, pair));
        }
        printNewLine();
    }

    public static void printInitializationInfo() {
        printNewLine();
        System.out.println(INITIALIZATION_INFO_MESSAGE);
        printNewLine();
    }

    public static void printNewLine() {
        System.out.print(NEW_LINE);
    }
}