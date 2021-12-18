package pairmatching;

public class Validator {

    private final String FUNCTION_FORMAT = "[1-3,Q]";
    private final String SEPARATOR = ", ";
    private final Printer printer = new Printer();

    public void validateFunctionInput(String input) {
        try {
            if (!input.matches(FUNCTION_FORMAT)) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_MESSAGE.getMessage());
            }
        } catch (IllegalArgumentException exception) {
            printer.printErrorMessage(exception);
        }
    }

    public void validateRematchingInput(String input) {
        try {
            if (input.equals("네") || input.equals("아니오")) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_MESSAGE.getMessage());
            }
        } catch (IllegalArgumentException exception) {
            printer.printErrorMessage(exception);
        }
    }

    public void validateCourseLevelMission(String input) {
        try {
            String[] splited = input.split(SEPARATOR);
            validateCourse(splited[0]);
            validateLevel(splited[1]);
            validateMissionName(splited[2]);
        } catch (IllegalArgumentException exception) {
            printer.printErrorMessage(exception);
        }
    }

    private void validateCourse(String input) {
        if (input.equals("프론트엔드") || input.equals("백엔드")) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_MESSAGE.getMessage());
    }

    private void validateLevel(String input) {
        for (Level level : Level.values()) {
            if (level.getName().equals(input)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_MESSAGE.getMessage());
    }

    private void validateMissionName(String input) throws IllegalArgumentException {
        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(input)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MISSION_NOT_FOUND_MESSAGE.getMessage());
    }

}
