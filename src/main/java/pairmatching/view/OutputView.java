package pairmatching.view;

import static pairmatching.constants.ProgressMessage.LINE;
import static pairmatching.constants.ProgressMessage.PAIR_MATCHING_RESULT;
import static pairmatching.view.common.Printer.printer;

import java.util.List;
import pairmatching.domain.Pair;

public class OutputView {
    public static void printErrorMessage(String message) {
        printer(message + LINE.getMessage());
    }

    public static void printMatchingResult(List<Pair> pairMatchingResult) {
        printer(PAIR_MATCHING_RESULT.getMessage());
        for (Pair pair : pairMatchingResult) {
            List<String> crews = pair.getCrews();
            String formattedOutput = String.join(" : ", crews);
            printer(formattedOutput);
        }
        printer(LINE.getMessage());
    }
}
