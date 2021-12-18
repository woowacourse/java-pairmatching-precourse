package pairmatching.util.io;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.io.message.IOMessage;
import pairmatching.util.io.message.Options;

public class IOProvider {

    public static char chooseWhatToDo() {
        System.out.println(IOMessage.WHAT_TO_DO.getMessage());
        printOptions();
        return Validator.isValidCharStart(Console.readLine());
    }

    private static void printOptions() {
        System.out.println(Options.WHAT_TO_DO_1.getMessage());
        System.out.println(Options.WHAT_TO_DO_2.getMessage());
        System.out.println(Options.WHAT_TO_DO_3.getMessage());
        System.out.println(Options.WHAT_TO_DO_4.getMessage());
    }

    public static String[] chooseWhatMissionToDo() {
        System.out.println();
        System.out.println(IOMessage.WHAT_MISSION_TO_CHOOSE.getMessage());
        return Validator.isValidMissionChoosen(Console.readLine());
    }

    public static void printMatchingResult(String matchingResult) {
        System.out.println();
        System.out.println(IOMessage.PAIR_RESULT_MESSAGE.getMessage());
        System.out.println(matchingResult);
    }

    public static boolean printAlreadyMatched() {
        System.out.println();
        System.out.println(IOMessage.ANSWER_REDO.getMessage());

        String answer = Validator.isValidAnswerRedo(Console.readLine());
        if(answer.equals("네"))
            return true;
        return false;
    }

    public static void printInit() {
        System.out.println();
        System.out.println(IOMessage.DONE_RESET.getMessage());
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static String[] rechooseWhatMissionToDo() {
        System.out.println();
        System.out.println(IOMessage.REANSWER.getMessage());
        return Validator.isValidMissionChoosen(Console.readLine());
    }
}
