package pairmatching.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";

    private static System system;

    Controller() throws IOException {
        system = new System();
    }

    public static void execute() {
        String inputFunction = getInputFunction();
        if (inputFunction.equals(PAIR_MATCHING_SIGN)) {
            initializeMatchingInfo();
        }
    }

    private static void initializeMatchingInfo() {
        List<String> matchInfoList = Arrays.asList(ConsoleInputView.inputMatchinInfo().split(COMMA_SEPARATION));
        randomMatch(matchInfoList.get(COURSE_INDEX).trim());
    }

    private static void randomMatch(final String courseName) {
        if (courseName.equals(BACKEND)) {
            system.randomMatchBE();
        }
        if (courseName.equals(FRONTEND)) {
            system.randomMatchFE();
        }
    }


    private static String getInputFunction() {
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
