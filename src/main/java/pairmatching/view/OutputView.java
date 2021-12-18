package pairmatching.view;

import static pairmatching.util.Constants.*;

import java.util.List;

public class OutputView {

    public static void printErrorMsg(Exception e) {
        System.out.println(ERROR + e.getMessage());
    }

    public static void printFairMatchingResult(List<String> fairs) {
        System.out.println(FAIR_MATCHING_RESULT_MSG);
        for (int i=0; i<fairs.size(); i++) {
            if (i % 2 == 0) {
                String resultMsg = fairs.get(i) + " : " + fairs.get(i+1);
                System.out.println(resultMsg);
            }
        }
    }

    public static void printWrongCLM() {
        System.out.println(WRONG_CLM_KEY);
    }

    public static void printfairInitMsg() {
        System.out.println(FAIR_INIT_MSG);
    }

    public static void printExitMsg() {
        System.out.println(EXIT_MSG);
    }
}
