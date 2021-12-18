package pairmatching;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_MESSAGE_ABOUT_FUNCTION_SELECTION = "기능을 선택하세요.";
    private static final String PAIR_MATCHING_FUNCTION = "1. 페어 매칭";
    private static final String PAIR_CHECK_FUNCTION = "2. 페어 조회";
    private static final String PAIR_INITIALIZATION_FUNCTION = "3. 페어 초기화";
    private static final String END_FUNCTION = "Q. 종료";
    private static final String PAIR_MATCHING_FUNCTION_KEY = "1";
    private static final String PAIR_CHECK_FUNCTION_KEY = "2";
    private static final String PAIR_INITIALIZATION_FUNCTION_KEY = "3";
    private static final String END_FUNCTION_KEY = "Q";
    private static final Set<String> function_keys = new HashSet<>(Arrays.asList(PAIR_MATCHING_FUNCTION_KEY, PAIR_CHECK_FUNCTION_KEY, PAIR_INITIALIZATION_FUNCTION_KEY, END_FUNCTION_KEY));

    public static String inputFunctionKey() {
        printRequestMessageAboutFunctionSelection();
        return inputUntilSucceed( () -> checkFunctionKey(input()));
    }

    private static String input() {
        return Console.readLine();
    }

    private static String checkFunctionKey(String input) {
        if(!function_keys.contains(input)) {
            throw new IllegalArgumentException("제시된 기능목록에서 선택해주세요");
        }
        return input;
    }

    private static void printRequestMessageAboutFunctionSelection() {
        System.out.println(REQUEST_MESSAGE_ABOUT_FUNCTION_SELECTION);
        System.out.println(PAIR_MATCHING_FUNCTION);
        System.out.println(PAIR_CHECK_FUNCTION);
        System.out.println(PAIR_INITIALIZATION_FUNCTION);
        System.out.println(END_FUNCTION);
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
        System.out.println(errorMessage);
    }

}
