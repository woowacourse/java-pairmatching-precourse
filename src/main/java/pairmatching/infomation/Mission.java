package pairmatching.infomation;

public class Mission {
    private int Level;
    private String name;

    public Mission(int level, String name) {
        Level = level;
        this.name = name;
    }

    public int getLevel() {
        return Level;
    }

    public String getName() {
        return name;
    }
}
