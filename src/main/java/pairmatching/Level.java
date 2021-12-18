package pairmatching;

import java.util.ArrayList;

public enum Level {
    LEVEL1("레벨1", 1),
    LEVEL2("레벨2", 2),
    LEVEL3("레벨3", 3),
    LEVEL4("레벨4", 4),
    LEVEL5("레벨5", 5);

    private String name;
    private int missionNumber;

    Level(String name, int missionNumber) {
        this.name = name;
        this.missionNumber = missionNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getMissionNumber() {
        return this.missionNumber;
    }

    public static String getMissionsByLevel(int missionNumber) {
        return Mission.returnNamesByMissionNumber(missionNumber);
    }
}
