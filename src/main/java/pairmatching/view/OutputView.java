package pairmatching.view;

import java.util.List;

public class OutputView {
    private static final String CLONE = " : ";
    private static final String RESULT_MESSAGE = "페어 매칭 결과입니다.";
    private static final String INIT_MESSAGE = "초기화 되었습니다.";

    public static void printMatchingResult() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(CLONE);
    }

    public static void printInit() {
        System.out.println(INIT_MESSAGE);
    }
}
