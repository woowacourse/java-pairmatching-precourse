package pairmatching.view;

import static pairmatching.utils.Constant.*;

import camp.nextstep.edu.missionutils.Console;

import pairmatching.utils.Validator;

import java.util.List;


public class InputView {
    public static String requestFunctionIndex() {
        String input;
        System.out.println(REQUEST_FUNCTION_INDEX);
        System.out.println(FUNCTION_LIST);
        input = Console.readLine();
        while(!Validator.isValidFunction(input)){
            input = Console.readLine();
        }

        return input;
    }

    public static List<String> requestCourseLevelMission() {
        String input;
        List<String> result;
        System.out.println(REQUEST_COURSE_LEVEL_MISSION);
        input = Console.readLine();
        while((result = Validator.isValidCourseLevelMission(input)).isEmpty()) {
        input = Console.readLine();
        }

        return result;
    }
}
