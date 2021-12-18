package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;
    private List<Mission> missions;

    Level(final String name) {
      this.name = name;
      missions = new ArrayList<>();
    }
    
    public void addMissions(Mission mission) {
        missions.add(mission);
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public String getName() {
        return name;
    }
    
    public static Level findByName(String name) {
        return Arrays.stream(Level.values()).
                filter(l -> l.getName().equals(name)).
                findAny().
                orElseThrow(IllegalArgumentException:: new);
    }
    
    public static Mission findbyMissionName(Level level, String mission) {
        return level.getMissions().stream()
                .filter(m -> m.getName().equals(mission))
                .findAny()
                .orElseThrow(IllegalArgumentException:: new);
    }
    
}
