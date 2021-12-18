package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.BASKET, Mission.PAYMENT, Mission.SUBWAY)),
    LEVEL3("레벨3", Arrays.asList(Mission.EMPTY)),
    LEVEL4("레벨4", Arrays.asList(Mission.IMPROVEMENT_PERFORMANCE, Mission.DISTRIBUTE)),
    LEVEL5("레벨5",  Arrays.asList(Mission.EMPTY));

    private String name;
    private List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }
}
