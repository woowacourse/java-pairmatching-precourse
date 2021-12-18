package pairmatching.model;

public enum Levels {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String level;

    Levels(String name) {
        this.level = name;
    }

    public String getLevel() {
        return level;
    }

}
