package pairmatching.util.validator;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.util.Condition;
import pairmatching.util.InputGenerator;
import pairmatching.view.message.ErrorMessage;

public class MatchingInfoValidator implements InputValidator {
    private static final MatchingInfoValidator instance = new MatchingInfoValidator();

    private MatchingInfoValidator() {
    }

    public static MatchingInfoValidator getInstance() {
        return instance;
    }

    @Override
    public void validate(String input) {
        validateCorrectFormat(input);
        String[] inputs = InputGenerator.splitByComma(input);
        validateCourse(inputs[0]);
        validateLevel(inputs[1]);
        validateMission(inputs[1], inputs[2]);
    }

    private void validateCorrectFormat(String input) {
        if (!input.matches(Condition.MATCHING_INFO_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_CORRECT_FORMAT.getMessage());
        }
    }

    private void validateCourse(String course) {
        if (Course.getCourseName().stream().noneMatch(name -> name.equals(course))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_EXIST_COURSE.getMessage());
        }
    }

    private void validateLevel(String level) {
        if (Level.getLevelName().stream().noneMatch(name -> name.equals(level))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_EXIST_LEVEL.getMessage());
        }
    }

    private void validateMission(String level, String mission) {
        if (Level.getMissionsName(level).stream().noneMatch(name -> name.equals(mission))) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_EXIST_MISSION.getMessage());
        }
    }
}
