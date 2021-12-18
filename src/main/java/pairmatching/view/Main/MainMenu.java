package pairmatching.view.Main;

public class MainMenu {
    private static String MAIN_MENU = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    public static void printMainMenu(){
        System.out.println(MAIN_MENU);
    }
}
