package pairmatching.code;

import static pairmatching.ErrorMessage.*;

import java.util.Arrays;

import pairmatching.domain.Level;

public enum MainCode {
    MATCHING("1"), SEARCH("2"), INITIALIZE("3"), QUIT("Q");
    private String code;

    MainCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static MainCode find(String name) {
        return Arrays.stream(MainCode.values())
            .filter(mainCode -> mainCode.getCode().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NO_OBJECT_ERROR));
    }
}
