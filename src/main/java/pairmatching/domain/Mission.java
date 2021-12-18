package pairmatching.domain;

public class Mission {
    private String missionName;
    private Level level;

    public Mission(String missionName, Level level) {
        this.missionName = missionName;
        this.level = level;
    }

    public String getMissionName() {
        return missionName;
    }

    public Level getLevel() {
        return level;
    }
}
