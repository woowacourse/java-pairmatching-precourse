package pairmatching.view;

import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.Pairs;
import pairmatching.message.ExceptionMessage;
import pairmatching.message.ViewMessage;

public class OutputView {
    public static void printException(Exception error) {
        System.out.println(ExceptionMessage.EXCEPTION_PREFIX + error.getMessage());
    }

    public static void printMatchingResult(Pairs matchingResult) {
        System.out.println(ViewMessage.OUTPUT_PAIR_RESULT_PRE_MESSAGE);
        for (Pair pair : matchingResult.getPairs()) {
            String pairString = String.join(ViewMessage.OUTPUT_PAIR_DELIMITER, pair.getCrews());
            System.out.println(pairString);
        }
    }
}
