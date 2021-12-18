package pairmatching.validator;

import java.util.Arrays;

public class Validator {
    private static final String[] MENU_LIST = {"1", "2", "3", "Q"};

    public void validateSelectMenu(String menu) {
        if (!Arrays.asList(MENU_LIST).contains(menu)) {
            throw new IllegalArgumentException("선태한 기능은 없는 기능입니다.");
        }
    }
}
