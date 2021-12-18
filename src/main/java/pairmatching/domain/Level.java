package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public static boolean isLevelName(String name) {
        if(getAllLevel().stream().anyMatch(level -> level.name.equals(name))) {
           return true;
        };
        return false;
    }

    private static List<Level> getAllLevel() {
        return Arrays.asList(values());
    }

    public static Optional<Level> findByName(String name) {
        return getAllLevel().stream().filter(level -> level.name.equals(name)).findAny();
    }




    // 추가 기능 구현
}
