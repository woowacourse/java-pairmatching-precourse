package pairmatching.View;

public class OutputView {
    private static final String MENU_DISPLAY = "\n기능을 선택하세요\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

    public void printMenu(){
        System.out.println(MENU_DISPLAY);
    }

    public static void printErrorMessage(RuntimeException e) {
        System.out.printf("[ERROR] "+ e.getMessage());
    }
}
