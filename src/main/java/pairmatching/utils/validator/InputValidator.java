package pairmatching.utils.validator;

import pairmatching.domain.enumeration.Course;
import pairmatching.domain.enumeration.Level;
import pairmatching.domain.enumeration.Mission;
import pairmatching.utils.ConstantMessages;


public class InputValidator {

    public static void validateCourseLevelMissionInput(String[] input) {
        String courseName = input[ConstantMessages.COURSE_INDEX];
        String level = input[ConstantMessages.LEVEL_INDEX].substring(ConstantMessages.SPACING);
        String mission = input[ConstantMessages.MISSION_INDEX].substring(ConstantMessages.SPACING);

        Course.findCourseByInput(courseName);
        Level levelByInput = Level.findLevelByInput(level);
        Level missionLevel = validateMission(mission);

        validateLevelAndMissionLevel(levelByInput, missionLevel);
    }

    private static void validateLevelAndMissionLevel(Level levelByInput, Level missionLevel) {
        if(levelByInput != missionLevel) {
            throw new IllegalArgumentException(ConstantMessages.PREFIX_ERROR + ConstantMessages.ERROR_INVALID_INPUT);
        }
    }

    private static Level validateMission(String mission) {
        Mission missionByInput = Mission.findMissionByInput(mission);
        return Level.findLevelByMission(missionByInput);
    }
}
