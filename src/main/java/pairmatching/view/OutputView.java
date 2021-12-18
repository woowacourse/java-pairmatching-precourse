package pairmatching.view;

import static pairmatching.StringConstants.DELIMITER_FOR_PAIR;
import static pairmatching.StringConstants.RESULT_NOTICE_MESSAGE_ABOUT_PAIR;

import java.util.List;

import pairmatching.domain.pair.Pair;

public class OutputView {

    public static void printPair(Pair pair) {
        System.out.println(RESULT_NOTICE_MESSAGE_ABOUT_PAIR);
         for(List<String> pairs : pair.getPairs()) {
             System.out.println(String.join(DELIMITER_FOR_PAIR, pairs));
         };
    }
}
