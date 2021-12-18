package pairmatching.view;

import java.util.Arrays;

public enum RematchMenu {
    REMATCH("네"),
    NO_OP("아니오");

    private final String symbol;

    RematchMenu(String symbol) {
        this.symbol = symbol;
    }

    public static RematchMenu of(String symbol) {
        return Arrays.stream(RematchMenu.values())
                .filter(menu -> menu.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다."));
    }

    public String getSymbol() {
        return symbol;
    }
}
