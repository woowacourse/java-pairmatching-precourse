package pairmatching.model;

import java.util.List;

public class LevelAndMission {
    private Level level;
    private List<Mission> missions;

    public LevelAndMission(Level level, List<Mission> missions) {
        this.level = level;
        this.missions = missions;
    }

    public Level getLevel() {
        return level;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
