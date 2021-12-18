package pairmatching.view;

import java.util.List;

public class OutputView {
    private static final String WINDOW_HASH = "#############################################";
    private static final String COURSE = "과정: 백엔드 | 프론트엔드";
    private static final String MISSION = "미션: ";
    private static final String LEVEL1 = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임";
    private static final String LEVEL2 = "  - 레벨2: 장바구니 | 결제 | 지하철노선도";
    private static final String LEVEL3 = "  - 레벨3: ";
    private static final String LEVEL4 = "  - 레벨4: 성능개선 | 배포";
    private static final String LEVEL5 = "  - 레벨5: ";
    private static final String DASH = " - ";
    private static final String TAB = "\t";
    private static final String ENTER = "\n";
    private static final String CLONE = " : ";
    public static final String VERTICAL_VAR = " | ";
    private static final String RESULT_MESSAGE = "페어 매칭 결과입니다.";
    private static final String INIT_MESSAGE = "초기화 되었습니다.";

    public static void printInformation() { // 출력에 따라 수정 필요
        System.out.println(WINDOW_HASH);
        System.out.println(COURSE);
        System.out.println(MISSION);
        System.out.println(LEVEL1);
        System.out.println(LEVEL2);
        System.out.println(LEVEL3);
        System.out.println(LEVEL4);
        System.out.println(LEVEL5);
        System.out.println(WINDOW_HASH);
    }

    public static void printMatchingResult(List<String> pairCrews) {
        System.out.println(RESULT_MESSAGE);
        for (String pairCrew : pairCrews) {
            System.out.println(pairCrew);
        }
        System.out.println("");
    }

    public static void printInit() {
        System.out.println(INIT_MESSAGE);
    }
}