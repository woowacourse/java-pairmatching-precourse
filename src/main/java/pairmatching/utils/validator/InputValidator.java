package pairmatching.utils.validator;

import pairmatching.domain.enumeration.Course;
import pairmatching.domain.enumeration.Level;
import pairmatching.domain.enumeration.Mission;
import pairmatching.utils.ErrorMessages;

public class InputValidator {
    private final static int COURSE_INDEX = 0;
    private final static int LEVEL_INDEX = 1;
    private final static int MISSION_INDEX = 2;
    private final static int SPACING = 1;

    private final static String YES = "네";
    private final static String NO = "아니오";

    public static void validateCourseLevelMissionInput(String[] input) {
        String courseName = input[COURSE_INDEX];
        String level = input[LEVEL_INDEX].substring(SPACING);
        String mission = input[MISSION_INDEX].substring(SPACING);

        Course.findCourseByInput(courseName);
        Level levelByInput = Level.findLevelByInput(level);
        Level missionLevel = validateMission(mission);

        validateLevelAndMissionLevel(levelByInput, missionLevel);
    }

    private static void validateLevelAndMissionLevel(Level levelByInput, Level missionLevel) {
        if(levelByInput != missionLevel) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX_ERROR + ErrorMessages.ERROR_INVALID_INPUT);
        }
    }

    private static Level validateMission(String mission) {
        Mission missionByInput = Mission.findMissionByInput(mission);
        return Level.findLevelByMission(missionByInput);
    }
}
