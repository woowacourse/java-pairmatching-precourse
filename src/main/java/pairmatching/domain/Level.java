package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String LEVEL_ERROR_MESSAGE = "[ERROR] 레벨 값은 1~5로 이루어져 있습니다."

    private final String name;

    public static Level ofName(String name){
        return Arrays.stream(values())
                .filter(level->level.name.equals(name))
                .findFirst()
                .orElseThrow();
    }

    Level(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
