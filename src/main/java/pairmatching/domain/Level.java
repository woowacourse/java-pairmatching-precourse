package pairmatching.domain;

import pairmatching.view.Message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private List<String> mission;

    Level(String name) {
        this.name = name;
    }

    public static Level of(String originName) {
        return Arrays.stream(values())
                .filter(n -> originName.equals(n.name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.NO_LEVEL));
    }
}