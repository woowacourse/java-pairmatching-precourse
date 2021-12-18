package pairmatching.model.enums;

import java.util.Arrays;

public enum Option {
    MATCH_PAIR("1"),
    SELECT_PAIR("2"),
    INITIAL_PAIR("3"),
    QUIT("Q");

    private final String value;

    Option(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Option findNameByValue(String value) {
        return Arrays.stream(Option.values())
                .filter(option -> option.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
