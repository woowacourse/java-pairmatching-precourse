package pairmatching.domain;

import static pairmatching.domain.Course.findMatchingCourse;
import static pairmatching.domain.Level.findMatchingLevel;
import static pairmatching.domain.Level.isValidatedMission;

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

    private List<String> getParsedInput(String choiceInput) {
        List<String> inputs = Arrays.asList(choiceInput.split(","));
        if (inputs.size() != INPUT_SIZE){
            throw new IllegalArgumentException("parsing 에러");
        }
        return inputs;
    }

    private void initialize(List<String> inputs) {
        initCourse(inputs.get(0));
        initLevel(inputs.get(1));
        initMission(level, inputs.get(2));
    }

    private void initCourse(String course) {
        this.course = findMatchingCourse(course);
    }

    private void initLevel(String level) {
        this.level = findMatchingLevel(level);
    }

    private void initMission(Level level, String mission) {
        if (!isValidatedMission(level, mission)){
            throw new IllegalArgumentException("존재자나이!");
        }
        this.mission = mission;
    }
}
