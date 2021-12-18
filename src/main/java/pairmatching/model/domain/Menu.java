package pairmatching.model.domain;

import java.util.Arrays;

import pairmatching.util.Message;

public enum Menu {
    PAIR_MATCHING("1"),
    PAIR_CHECK("2"),
    PAIR_RESET("3"),
    STOP("Q");

    private String menuIndex;

    Menu(String input) {
        this.menuIndex = input;
    }

    public String getMenuIndex() {
        return menuIndex;
    }

    public static Menu parseMenu(String input) {
        return Arrays.stream(values())
            .filter(menu -> menu.menuIndex.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Message.MENU_ERROR));
    }
}
