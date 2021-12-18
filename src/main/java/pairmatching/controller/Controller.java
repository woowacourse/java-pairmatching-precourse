package pairmatching.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.System;
import pairmatching.utils.Validator;
import pairmatching.view.ConsoleInputView;
import pairmatching.view.OutputView;

public class Controller {

    private static final String PAIR_MATCHING_SIGN = "1";
    private static final String COMMA_SEPARATION = ",";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final System system;

    public Controller() throws IOException {
        system = new System();
    }

    public void execute() {
        String inputFunction = getInputFunction();
        if (inputFunction.equals(PAIR_MATCHING_SIGN)) {
            initializeMatchingInfo();
        }
    }

    private void initializeMatchingInfo() {
        List<String> matchInfoList = Arrays.asList(ConsoleInputView.inputMatchingInfo().split(COMMA_SEPARATION));
        randomMatch(matchInfoList.get(COURSE_INDEX).trim(),
            matchInfoList.get(LEVEL_INDEX).trim(),
            matchInfoList.get(MISSION_INDEX).trim());

    }

    private void randomMatch(final String courseName, final String level, final String mission) {
        system.randomMatch(courseName, level, mission);
        OutputView.printPairs(system.getMatchingInfo(Course.getCourse(courseName), Level.getLevel(level), mission));
    }

    private String getInputFunction() {
        String inputFunction;
        try {
            inputFunction = ConsoleInputView.inputFunction();
            Validator.validateFunctionInput(inputFunction);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            inputFunction = getInputFunction();
        }
        return inputFunction;
    }

}
