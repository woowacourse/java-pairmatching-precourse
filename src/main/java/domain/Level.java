package domain;

import java.util.List;
import java.util.ArrayList;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;
    private List<String> missions;

    Level(final String name) {
      this.name = name;
      missions = new ArrayList<>();
    }
    
    public void addMissions(String mission) {
        missions.add(mission);
    }
    
}
