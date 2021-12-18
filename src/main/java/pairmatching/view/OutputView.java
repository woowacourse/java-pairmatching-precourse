package pairmatching.view;

import static pairmatching.util.Constants.*;

import java.util.List;

public class OutputView {

    public static void printErrorMsg(Exception e) {
        System.out.println(ERROR + e.getMessage());
    }

    public static void printFairMatchingResult(List<String> fairs) {
        System.out.println(FAIR_MATCHING_RESULT_MSG);
        for (int i=0; i<fairs.size(); i+=2) {
            System.out.println(fairs.get(i) + " : " + fairs.get(i+1));
        }
    }

    public static void printWrongCLM() {
        System.out.println();
    }

    public static void printfairInitMsg() {
        System.out.println(FAIR_INIT_MSG);
    }
}
