package pairmatching;

import java.util.ArrayList;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private ArrayList<String> mission = new ArrayList<>();

    Level(String name) {
        this.name = name;
    }

    public static Boolean JudgeLevel(String inputLevel) {
        for (Level level : Level.values()) {
            if (level.name.equals(inputLevel)) {
                return true;
            }
        }
        return false;
    }
}