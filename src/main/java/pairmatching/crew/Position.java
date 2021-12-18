package pairmatching.crew;

import java.util.Arrays;

public enum Position {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String ERR_INVALID_NAME = "포지션은 백엔드와 프론트엔드만 가능합니다";
    private final String position;

    Position(String position) {
        this.position = position;
    }

    public static Position of(String positionName) {
        return Arrays.stream(Position.values())
            .filter(p -> p.position.equals(positionName))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_NAME));
    }

    public String getPosition() {
        return this.position;
    }
}
