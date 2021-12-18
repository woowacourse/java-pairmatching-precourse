package pairmatching.utils;

import pairmatching.model.enums.Course;
import pairmatching.model.enums.Level;

import static pairmatching.model.enums.Option.*;

public class Validator {
    private final static String ERROR_INPUT_OPTION = "[ERROR] 잘못된 번호를 선택하셨습니다.";

    public Validator() {
    }

    public boolean isValidOption(String input) {
        if (MATCH_PAIR.getValue().equals(input)
                || SELECT_PAIR.getValue().equals(input)
                || INITIAL_PAIR.getValue().equals(input)
                || QUIT.getValue().equalsIgnoreCase(input)) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_INPUT_OPTION);
    }

    public boolean isValidDetails(String input) {
        String[] details = input.split(",");
        if (isValidPrecourse(details[0].trim())
                && isValidLevel(details[1].trim())
                && isValidMission(details[1].trim(), details[2].trim())) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_INPUT_OPTION);
    }

    private boolean isValidPrecourse(String input) {
        return Course.isContained(input);
    }

    private boolean isValidLevel(String input) {
        return Level.isContainedLevel(input);
    }

    private boolean isValidMission(String level, String mission) {
        return Level.isContainedMission(level, mission);
    }
}