package pairmatching.domain.option;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.repository.Missions;
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
        return Missions.isExistingMissionInCorrectLevel(level, mission);
    }
}
