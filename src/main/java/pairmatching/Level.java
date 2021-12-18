package pairmatching;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String mission;
    private String name;

    Level(String name) {
        this.name = name;
    }

    public String getMission() {
        return mission;
    }

    public String getName() {
        return name;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

}
