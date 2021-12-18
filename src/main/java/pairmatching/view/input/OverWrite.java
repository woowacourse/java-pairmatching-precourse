package pairmatching.view.input;

import java.util.Arrays;

public enum OverWrite {
    YES("네"),
    NO("아니오");

    private final String value;

    OverWrite(final String value) {
        this.value = value;
    }

    public static OverWrite of(final String value) {
        return Arrays.stream(values())
                .filter(overWrite -> overWrite.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("대답은 네 혹은 아니오 입니다."));
    }
}
