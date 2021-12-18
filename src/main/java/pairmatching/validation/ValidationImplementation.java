package pairmatching.validation;

import pairmatching.ConstantDataStore;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidationImplementation implements Validation {

    private static final Pattern FUNCTION_SELECT_VALID_DIGIT_PATTERN = Pattern.compile("^[1-3]*$");
    private static final int FUNCTION_LIST_INPUT_LIMITED_LENGTH = 1;
    private static final char EXIT_NOTATION = 'Q';
    private static final int PROPERTY_INPUT_FORMAT_LENGTH = 3;

    private final ConstantDataStore constantDataStore;

    public ValidationImplementation() {
        constantDataStore = ConstantDataStore.getInstance();
    }

    public static ValidationImplementation getInstance() {
        return ValidationImplementation.LazyHolder.INSTANCE;
    }

    public boolean isValidFunctionListInput(String functionNumberInput) {
        if (functionNumberInput.length() != FUNCTION_LIST_INPUT_LIMITED_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (isValidSignificantFigures(functionNumberInput) || isQuitNotation(functionNumberInput)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isValidPropertySelectionInput(String propertySelectingInput) {
        if (isNotExistComma(propertySelectingInput)) {
            throw new IllegalArgumentException();
        }
        String[] courseAndLevelAndMission = propertySelectingInput.split(",");
        if (courseAndLevelAndMission.length != PROPERTY_INPUT_FORMAT_LENGTH) {
            throw new IllegalArgumentException();
        }
        String course = courseAndLevelAndMission[0];
        String level = courseAndLevelAndMission[1];
        String mission = courseAndLevelAndMission[2];
        if (!(isContainCourse(course) && isContainLevel(level) && isContainLevelMission(mission))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isContainCourse(String inputCourse) {
        for (Course course : Course.values()) {
            if (course.getCourse().equals(inputCourse)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainLevel(String inputLevel) {
        inputLevel=inputLevel.substring(1);
        for (Level course : Level.values()) {
            if (course.getLevel().equals(inputLevel)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainLevelMission(String inputMission) {
        inputMission=inputMission.substring(1);
        Map<Level, List<String>> missionByLevel = constantDataStore.getMissionByLevel();
        boolean isContainMission = false;
        for (Level level : missionByLevel.keySet()) {
            List<String> missions = missionByLevel.get(level);
            isContainMission = isContainMission(inputMission, missions);
            if (isContainMission) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainMission(String inputMission, List<String> missions) {
        for (String mission : missions) {
            if (mission.equals(inputMission)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotExistComma(String propertySelectingInput) {
        return propertySelectingInput.indexOf(',') == -1;
    }

    private static class LazyHolder {

        public static final ValidationImplementation INSTANCE = new ValidationImplementation();
    }

    private boolean isValidSignificantFigures(String functionNumberInput) {
        return FUNCTION_SELECT_VALID_DIGIT_PATTERN.matcher(functionNumberInput).matches();
    }

    private boolean isQuitNotation(String functionNumberInput) {
        return functionNumberInput.charAt(0) == EXIT_NOTATION;
    }
}
