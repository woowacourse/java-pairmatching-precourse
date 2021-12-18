package pairmatching;

import java.util.List;

public enum Level {
    LEVEL1("레벨1", Mission.LEVEL1),
    LEVEL2("레벨2", Mission.LEVEL2),
    LEVEL3("레벨3", Mission.LEVEL3),
    LEVEL4("레벨4", Mission.LEVEL4),
    LEVEL5("레벨5", Mission.LEVEL5);

    private String name;
    private Mission missions;

    Level(String name, Mission missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public String getMissions() {
        return missions.getMission();
    }
}
