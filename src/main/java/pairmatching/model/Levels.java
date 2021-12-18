package pairmatching.model;

public enum Levels {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Levels(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
