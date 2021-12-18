package pairmatching.view;

import java.util.Arrays;

public enum Function {
    MATCHING("1"),
    CHECK("2"),
    RESET("3"),
    QUIT("Q");

    private final String symbol;

    Function(final String symbol) {
        this.symbol = symbol;
    }

    public static Function of(String symbol) {
        return Arrays.stream(values())
                .filter(function -> function.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("기능에 대한 입력이 잘못되었습니다."));
    }
}
