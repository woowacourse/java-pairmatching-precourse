package pairmatching.view;

import java.util.List;

public class OutputView {
    private static final String WINDOW_HASH = "#############################################";
    private static final String COURSE = "과정: ";
    private static final String MISSION = "미션: ";
    private static final String DASH = " - ";
    private static final String TAB = "\t";
    private static final String ENTER = "\n";
    private static final String CLONE = " : ";
    public static final String VERTICAL_VAR = " | ";
    private static final String RESULT_MESSAGE = "페어 매칭 결과입니다.";
    private static final String INIT_MESSAGE = "초기화 되었습니다.";

    public static void printInformation(List<String> courses, List<String> levels, List<String> mission) { // 출력에 따라 수정 필요
        System.out.println(WINDOW_HASH);
        System.out.println(COURSE + String.join(CLONE, courses));
        System.out.println(MISSION);
        for (String level : levels) {
            System.out.println(TAB);
        }
        System.out.println(DASH);
        System.out.println(WINDOW_HASH);
    }

    public static void printMatchingResult() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(CLONE);
    }

    public static void printInit() {
        System.out.println(INIT_MESSAGE);
    }
}
