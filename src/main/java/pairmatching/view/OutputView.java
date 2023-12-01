package pairmatching.view;

import static pairmatching.constants.ProgressMessage.*;
import static pairmatching.view.common.Printer.*;
import static pairmatching.view.common.Printer.printer;

import java.util.List;
import pairmatching.constants.ProgressMessage;
import pairmatching.domain.Pair;
import pairmatching.view.common.Printer;

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
