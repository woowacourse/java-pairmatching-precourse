package pairmatching.view.ouput;

import static pairmatching.view.constant.InputMessage.*;
import static pairmatching.view.constant.OutputMessage.*;
import static pairmatching.view.constant.PrintFormat.RESPONSE_PAIR_RESULT;

import java.util.List;
import pairmatching.domain.Crew;

public final class OutputView extends OutputWriter {

    public static void displayProcessOfPair(){
        printMessageResponse(DISPLAY_PROCESS);
    }

    public static void printPairs(List<Crew> shuffledCrews) {
        for (int i = 0; i < shuffledCrews.size() - 1; i += 2) {
            printfDoubleFormat(RESPONSE_PAIR_RESULT, shuffledCrews.get(i).getName(), shuffledCrews.get(i + 1).getName());
        }
        if (shuffledCrews.size() % 2 != 0) {
            println(shuffledCrews.get(shuffledCrews.size() - 1).getName());
        }
    }
}