package domain.entity;

import java.util.Arrays;
import java.util.List;
import util.ExceptionUtil;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.SHOPPING_CART, Mission.PAYMENT, Mission.SUBWAY_MAP)),
    LEVEL3("레벨3", Arrays.asList()),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DEPLOYMENT)),
    LEVEL5("레벨5", Arrays.asList());

    private final String name;
    private final List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level findLevel(String levelName) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(levelName))
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public Mission findMission(String missionName) {
        return this.missions
                .stream()
                .filter(mission -> mission.getDescription().equals(missionName))
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return missions;
    }

}