package pairmatching;

import static pairmatching.StringConstants.*;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class InputView {
    public static String inputFunctionKey() {
        printRequestMessageAboutFunctionSelection();
        return inputUntilSucceed( () -> checkFunctionKey(input()));
    }

    public static String[] inputPairInfoToPerformFunction(List<String> allMissionNames, Map<Level, List<String>> missionNamesByLevel) {
        printPriorKnowledge(missionNamesByLevel);
        printRequestMessageAboutPairInfo();
        String[] PairInfoToPerformFunction = input().split(", ");
        checkCourseName(PairInfoToPerformFunction[0]);
        checkLevelName(PairInfoToPerformFunction[1]);
        checkMissionName(PairInfoToPerformFunction[1], PairInfoToPerformFunction[2], allMissionNames, missionNamesByLevel);
        return PairInfoToPerformFunction;
    }

    private static void printRequestMessageAboutPairInfo() {
        System.out.println(REQUEST_MESSAGE_ABOUT_PAIR_INFO);
        System.out.println(EXAMPLE_MESSAGE_ABOUT_PAIR_INFO);
    }

    private static String input() {
        return Console.readLine();
    }

    private static String checkFunctionKey(String input) {
        if(!FUNCTION_KEYS.contains(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_FUNCTION_INPUT);
        }
        return input;
    }

    private static void printRequestMessageAboutFunctionSelection() {
        System.out.println();
        System.out.println(REQUEST_MESSAGE_ABOUT_FUNCTION_SELECTION);
        System.out.println(PAIR_MATCHING_FUNCTION);
        System.out.println(PAIR_CHECK_FUNCTION);
        System.out.println(PAIR_INITIALIZATION_FUNCTION);
        System.out.println(END_FUNCTION);
    }

    private static void printPriorKnowledge(Map<Level, List<String>> missionNamesByLevel) {
        System.out.println(DIVIDING_LINE);
        printCourseKnowledge();
        printMissionKnowledge(missionNamesByLevel);
        System.out.println(DIVIDING_LINE);
    }

    private static void printCourseKnowledge() {
        System.out.print(COURSE);
        System.out.print(DELIMITER);
        System.out.print(Course.BACKEND.name());
        System.out.print(DELIMITER_BETWEEN_ITEM);
        System.out.println(Course.FRONTEND.name());
    }
    private static void printMissionKnowledge(Map<Level, List<String>> missionNamesByLevel) {
        System.out.print(MISSION);
        System.out.println(DELIMITER);
        for (Level level : Level.values()) {
            printMissionKnowledgeByLevel(level, missionNamesByLevel.get(level));
        }
    }

    private static void printMissionKnowledgeByLevel(Level level, List<String> missionNames) {
        System.out.print(DELIMITER_FOR_LIST_ITEM);
        System.out.print(level.name());
        System.out.print(DELIMITER);
        System.out.println(String.join(DELIMITER_BETWEEN_ITEM, missionNames));
    }

    private static void checkCourseName(String nameInput) {
        if(!Course.isCourseName(nameInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_COURSE_INPUT);
        }
    }

    private static void checkLevelName(String nameInput) {
        if(!Level.isLevelName(nameInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_LEVEL_INPUT);
        }
    }

    private static void checkMissionName(String levelNameInput, String missionNameInput, List<String> allMissionNames, Map<Level, List<String>> missionNamesByLevel) {
        if(!allMissionNames.contains(missionNameInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_MISSION_INPUT);
        }
        if(!missionNamesByLevel.get(Level.findByName(levelNameInput).get()).contains(missionNameInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_LEVEL_MISSION_INPUT);
        }
    }

    private static String inputUntilSucceed(Supplier<String> input) {
        String inputValue = null;
        while (true) {
            try {
                inputValue = input.get();
                break;
            } catch (IllegalArgumentException error) {
                printErrorMessage(error.getMessage());
            }
        }
        return inputValue;
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.print(PREFIX_OF_ERROR_MESSAGE);
        System.out.println(errorMessage);
    }
}
