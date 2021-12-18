package pairmatching.model;

import java.util.Arrays;

public enum Menu {
    PAIR_MATCHING("1"),
    PAIR_CHECK("2"),
    PAIR_RESET("3"),
    STOP("4");

    private String menuIndex;

    Menu(String input) {
        this.menuIndex = input;
    }

    public static Menu parseMenu(String input) {
        return Arrays.stream(values())
            .filter(menu -> menu.menuIndex.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException());
    }
}
