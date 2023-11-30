package pairmatching.domain;

import pairmatching.domain.constants.Level;
import pairmatching.domain.constants.Position;

public class Course {
    private final Level level;
    private final Position position;
    private final String mission;

    public Course(Level level, Position position, String mission) {
        this.level = level;
        this.position = position;
        this.mission = mission;
    }
}
