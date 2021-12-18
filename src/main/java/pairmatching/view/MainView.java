package pairmatching.view;

public class MainView {
    private static final String MAIN_PROMPT = "\n기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    public static void printSelectMode() {
        System.out.println(MAIN_PROMPT);
    }
}
