package pairmatching.domain.option;

import java.util.Objects;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.repository.MissionsByLevel;
import pairmatching.util.ExceptionMessage;

public class PairingOption {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairingOption(Course course, Level level, Mission mission) {
        validateOption(level, mission);
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    private void validateOption(Level level, Mission mission) {
        if (!isExistingMissionInCorrectLevel(level, mission)) {
            throw new IllegalArgumentException(ExceptionMessage.NO_SUCH_MISSION_IN_SUCH_LEVEL.getMessage());
        }
    }

    private boolean isExistingMissionInCorrectLevel(Level level, Mission mission) {
        return MissionsByLevel.isExistingMissionInCorrectLevel(level, mission);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairingOption that = (PairingOption) o;
        return course == that.course && level == that.level && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}

