package pairmatching.view;

import java.util.Arrays;

public enum Menu {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_SEARCH("2", "페어 조회"),
    PAIR_CLEAR("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String symbol;
    private final String name;

    Menu(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public static Menu of(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
