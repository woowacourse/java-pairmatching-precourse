package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public static List<Level> getList() {
        return Arrays.stream(Level.values())
                .sequential()
                .collect(Collectors.toList());
    }
    public static Level getEnumLevel(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.getName().equals(name))
                .collect(Collectors.toList()).get(0);
    }

    public static boolean isExist(String name) {
        List<Level> result =  Arrays.stream(Level.values())
                .filter(level -> level.getName().equals(name))
                .collect(Collectors.toList());
        if (result.size() == 1) {
            return true;
        }
        return false;
    }
}