package pairmatching.domain;

import static pairmatching.domain.Course.findMatchingCourse;
import static pairmatching.domain.Level.findMatchingLevel;
import static pairmatching.domain.Level.isValidatedMission;
import static pairmatching.ui.Messages.INVALID_INPUT_STRUCT;
import static pairmatching.ui.Messages.INVALID_MISSION;

import java.util.Arrays;
import java.util.List;

public class MatchingChoice {
    private static final int INPUT_SIZE = 3;

    private Course course;
    private Level level;
    private String mission;

    public MatchingChoice(String choiceInput) {
        parseChoiceInput(choiceInput);
    }

    private void parseChoiceInput(String choiceInput) {
        List<String> inputs = getParsedInput(choiceInput);
        initialize(inputs);
    }

    private List<String> getParsedInput(String choiceInput) throws IllegalArgumentException{
        List<String> inputs = Arrays.asList(choiceInput.split(","));
        if (inputs.size() != INPUT_SIZE){
            throw new IllegalArgumentException(INVALID_INPUT_STRUCT.getMessage());
        }
        return inputs;
    }

    private void initialize(List<String> inputs) {
        initCourse(inputs.get(0).trim());
        initLevel(inputs.get(1).trim());
        initMission(level, inputs.get(2).trim());
    }

    private void initCourse(String course) {
        this.course = findMatchingCourse(course);
    }

    private void initLevel(String level) {
        this.level = findMatchingLevel(level);
    }

    private void initMission(Level level, String mission) {
        if (!isValidatedMission(level, mission)){
            throw new IllegalArgumentException(INVALID_MISSION.getMessage());
        }
        this.mission = mission;
    }
}
