package pairmatching.domain;

import java.util.List;
import pairmatching.exception.ExceptionMessage;

public class MatchingConditions {

    private static final int INPUT_SIZE = 3;
    private final Course course;
    private final Level level;
    private final Mission mission;

    public MatchingConditions(List<String> conditions) {
        validateSize(conditions);
        this.course = Course.from(conditions.get(0));
        this.level = Level.from(conditions.get(1));
        this.mission = Mission.from(conditions.get(2));
    }

    private void validateSize(List<String> conditions) {
        if (conditions.size() != INPUT_SIZE) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_MATCHING_CONDITIONS.getMessage());
        }
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
