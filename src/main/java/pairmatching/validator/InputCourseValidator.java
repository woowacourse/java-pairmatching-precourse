package pairmatching.validator;

import static pairmatching.constants.ErrorMessage.INPUT_FORMAT_ERROR;
import static pairmatching.constants.ErrorMessage.INPUT_NO_VALUE;
import static pairmatching.constants.ErrorMessage.INVALID_LEVEL_ERROR;
import static pairmatching.constants.ErrorMessage.INVALID_LEVEL_MISSION_ERROR;
import static pairmatching.constants.ErrorMessage.INVALID_MISSION_ERROR;
import static pairmatching.constants.ErrorMessage.INVALID_POSITION_ERROR;

import pairmatching.domain.Course;
import pairmatching.domain.constants.Level;
import pairmatching.domain.constants.Position;

public class InputCourseValidator {
    public static Course validateInputCourse(String inputCourse) {
        validateInput(inputCourse);
        String[] parts = inputCourse.split(", ");

        if (parts.length != 3) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR.getMessage());
        }

        Position position = validatePosition(parts[0]);
        Level level = validateLevel(parts[1]);
        String mission = validateMission(level, parts[2]);
        return new Course(level, position, mission);
    }

    private static void validateInput(String course) {
        if (course == null || course.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NO_VALUE.getMessage());
        }
    }

    private static Position validatePosition(String part) {
        for (Position position : Position.values()) {
            if (position.getPosition().equals(part)) {
                return position;
            }
        }
        throw new IllegalArgumentException(INVALID_POSITION_ERROR.getMessage());
    }

    private static Level validateLevel(String part) {
        for (Level level : Level.values()) {
            if (level.getName().equals(part)) {
                return level;
            }
        }
        throw new IllegalArgumentException(INVALID_LEVEL_ERROR.getMessage());
    }

    private static String validateMission(Level level, String part) {
        if (level.getMissions() == null) {
            throw new IllegalArgumentException(String.format(INVALID_MISSION_ERROR.getMessage(), level.getName()));
        }
        for (String mission : level.getMissions()) {
            if (mission.equals(part)) {
                return mission;
            }
        }
        throw new IllegalArgumentException(String.format(INVALID_LEVEL_MISSION_ERROR.getMessage(), level.getName()));
    }

}
