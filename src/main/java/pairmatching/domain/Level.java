package pairmatching.domain;

import pairmatching.utils.ExceptionMessage;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Level getLevelByName(String name){
        return Arrays.stream(Level.values())
                .filter(value -> value.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}