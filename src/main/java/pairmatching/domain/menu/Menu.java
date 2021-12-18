package pairmatching.domain.menu;

import java.util.Arrays;

public class Menu {
    public static final String OPTION_ONE = "1";
    public static final String OPTION_TWO = "2";
    public static final String OPTION_THREE = "3";
    public static final String OPTION_QUIT = "4";
    public static final String NON_EXIST_MENU_EXCEPTION = "1, 2, 3, Q 중 하나를 선택해주세요";

    private String input;

    public Menu(String input) {
        validateMenuSelect(input);
        this.input = input;
    }

    public boolean isEnd() {
        return OPTION_QUIT.equals(input);
    }

    private void validateMenuSelect(String input) {
        if (!inputMenuExist(input)) {
            throw new IllegalArgumentException(NON_EXIST_MENU_EXCEPTION);
        }
    }

    private boolean inputMenuExist(String input) {
        if (OPTION_ONE.equals(input) || OPTION_TWO.equals(input) ||
            OPTION_THREE.equals(input) || OPTION_QUIT.equals(input)) {
            return true;
        }
        return false;
    }
}
