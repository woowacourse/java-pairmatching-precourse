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
    private static final String PAIR_LOOKING_UP_SIGN = "2";
    private static final String PAIR_INITIALIZATION_SIGN = "3";
    private static final String TERMINATING_SIGN = "Q";
    private static final String COMMA_SEPARATION = ",";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final System system;

    public Controller() throws IOException {
        system = new System();
    }

    public void execute() {
        String inputFunction;
        do {
            inputFunction = getInputFunction();

            if (inputFunction.equals(PAIR_MATCHING_SIGN)) {
                pushMatchingInfo();
            }
            
            if (inputFunction.equals(PAIR_INITIALIZATION_SIGN)) {
                initializeMatchingInfo();
            }
        } while (!inputFunction.equals(TERMINATING_SIGN));
    }

    private void pushMatchingInfo() {
        List<String> matchInfoList = Arrays.asList(ConsoleInputView.inputMatchingInfo().split(COMMA_SEPARATION));
        randomMatch(matchInfoList.get(COURSE_INDEX).trim(),
            matchInfoList.get(LEVEL_INDEX).trim(),
            matchInfoList.get(MISSION_INDEX).trim());
        OutputView.printNewLine();
    }

    private void initializeMatchingInfo() {
        system.initializeMatchingInfos();
        OutputView.printInitializationInfo();
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
