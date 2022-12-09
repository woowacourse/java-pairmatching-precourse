package pairmatching.ui;

import static pairmatching.ui.InputReader.getUserInput;

public class InputView {
    private static final String CHOOSE_MENU_OPENING = "기능을 선택하세요.";
    private static final String MAIN_MENU = "1. 페어 매칭/n2. 페어 조회/n3. 페어 초기화/nQ. 종료";

    public String inputMenuChoice() {
        System.out.println(CHOOSE_MENU_OPENING);
        System.out.println(MAIN_MENU);
        return getUserInput();
    }
}
