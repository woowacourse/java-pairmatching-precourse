package pairmatching.dto;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Level;

public class LevelDto {
    private final String name;
    private final List<String> missions = new ArrayList<>();

    public LevelDto(Level level) {
        this.name = level.toString();
        level.getMissions().forEach(mission -> missions.add(mission.toString()) );
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }
}
