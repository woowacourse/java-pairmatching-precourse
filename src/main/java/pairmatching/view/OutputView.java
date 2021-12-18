package pairmatching.view;

import pairmatching.domain.Pairs;

public class OutputView {
    private static final String SEPARATOR = "#############################################";
    private static final String PRINT_COURSE = "과정: 백엔드 | 프론트엔드";
    private static final String PRINT_MISSION = "미션:";
    private static final String PRINT_LEVEL_ONE = "    - 레벨1: 자동차경주 | 로또 | 숫자야구게임";
    private static final String PRINT_LEVEL_TWO = "    - 레벨2: 장바구니 | 결제 | 지하철노선도";
    private static final String PRINT_LEVEL_THREE = "    - 레벨3:";
    private static final String PRINT_LEVEL_FOUR = "    - 레벨4: 성능개선 | 배포";
    private static final String PRINT_LEVEL_FIVE = "    - 레벨5:";

    private static final String PRINT_REMOVE_ALL = "초기화 되었습니다.";

    private static final String PRINT_MATCHING_RESULT = "페어 매칭 결과입니다.";
    private static final String PRINT_MATCHING_RESULT_NOT_EXIST = "페어 매칭 결과가 존재하지 않습니다.";

    public static void printSelectMenu() {
        System.out.println(SEPARATOR);
        System.out.println(PRINT_COURSE);
        System.out.println(PRINT_MISSION);
        System.out.println(PRINT_LEVEL_ONE);
        System.out.println(PRINT_LEVEL_TWO);
        System.out.println(PRINT_LEVEL_THREE);
        System.out.println(PRINT_LEVEL_FOUR);
        System.out.println(PRINT_LEVEL_FIVE);
        System.out.println(SEPARATOR);
    }

    public static void printResult(Pairs pairs) {
        if (pairs == null || pairs.getPairList().isEmpty()) {
            System.out.println(PRINT_MATCHING_RESULT_NOT_EXIST);
            printLineBreak();
            return;
        }
        System.out.println(PRINT_MATCHING_RESULT);
        pairs.getPairList().forEach(pair -> System.out.println(pair));
        printLineBreak();
    }

    public static void printResetAll() {
        System.out.println(PRINT_REMOVE_ALL);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }


    public static void printLineBreak() {
        System.out.println();
    }
}
