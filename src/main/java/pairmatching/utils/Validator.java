package pairmatching.utils;

import pairmatching.Course;
import pairmatching.Level;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.utils.Constant.*;

public class Validator {
    public static boolean isValidFunction(String input) {
        try {
            validateLength(input);
            validateIndex(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void validateLength(String input) {
        if(input.length() != INPUT_INDEX_LENGTH) {
            throw new IllegalArgumentException(INPUT_ONLY_INDEX_ERROR_MESSAGE);
        }
    }

    public static void validateIndex(String input) {
        if(!(FUNCTION_INDEX_STRING.contains(input))){
            throw new IllegalArgumentException(INPUT_EXIST_FUNCTION_ERROR_MESSAGE);
        }
    }

    public static List<String> isValidCourseLevelMission(String input) {
        List<String> list = splitCourseLevelMission(input);
        if (checkLengthAndValidElement(list)) {
            return list;
        }
        return Collections.emptyList();
    }

    public static boolean checkLengthAndValidElement(List<String> list) {
        try {
            validateListLength(list);
            validateAllElement(list);
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_EXIST_FUNCTION_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private static void validateListLength(List<String> list) {
        if (list.size() != NEED_LIST_LENGTH) {
            throw new IllegalArgumentException(LIST_LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean validateAllElement(List<String> list) {
        try {
            Course.valueOf(list.get(0));
            Level.valueOf(list.get(1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static List<String> splitCourseLevelMission(String input) {
        return Arrays.stream(input.split(SPLIT_BY))
                .collect(Collectors.toList());
    }
}
