package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1", new Mission[]{Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL}),
    LEVEL2("레벨2", new Mission[]{Mission.SHOPPING_BASKET, Mission.PAYMENT, Mission.SUBWAY_MAP}),
    LEVEL3("레벨3", new Mission[]{}),
    LEVEL4("레벨4", new Mission[]{Mission.PERFORMANCE, Mission.DISTRIBUTE}),
    LEVEL5("레벨5", new Mission[]{});

    private String name;
    private Mission[] missions;

    Level(String name, Mission[] missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public static Level getLevelByName(String levelName) {
        for (Level l : Level.values()) {
            if (l.name.equals(levelName)) {
                return l;
            }
        }
        return null;
    }

    public static List<String> getLevelName() {
        return Arrays.stream(Level.values()).map(Level::getName).collect(Collectors.toList());
    }

    public static List<String> getMissionsName(String levelName) {
        Level level = Level.getLevelByName(levelName);
        return Arrays.stream(level.missions).map(Mission::getName).collect(Collectors.toList());
    }
}
