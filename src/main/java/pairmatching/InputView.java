package pairmatching;

import static pairmatching.InputReader.getUserInput;

public class InputView {
    private static final String CHOOSE_MENU_OPENING = "기능을 선택하세요.";

    public String inputMenuChoice() {
        System.out.println(CHOOSE_MENU_OPENING);
        return getUserInput();
    }
}
