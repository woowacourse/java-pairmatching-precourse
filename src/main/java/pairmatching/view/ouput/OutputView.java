package pairmatching.view.ouput;

import static pairmatching.view.constant.InputMessage.*;
import static pairmatching.view.constant.OutputMessage.*;
import static pairmatching.view.constant.PrintFormat.*;

import java.util.List;
import pairmatching.domain.Crew;

public final class OutputView extends OutputWriter {

    public static void displayProcessOfPair(){
        printMessageResponse(DISPLAY_PROCESS);
    }

    public static void printPairs(List<Crew> shuffledCrews) {
        printMessageResponse(RESPONSE_PAIR_MATCHING);
        for (int i = 0; i < shuffledCrews.size() - 1; i += 2) {
            if (shuffledCrews.size() % 2 != 0 && i == shuffledCrews.size() - 3) {
                printfTripleFormat(RESPONSE_PAIR_RESULT_ODD, shuffledCrews.get(i).getName(), shuffledCrews.get(i + 1).getName(), shuffledCrews.get(i + 2).getName());
                break;
            }
            printfDoubleFormat(RESPONSE_PAIR_RESULT, shuffledCrews.get(i).getName(), shuffledCrews.get(i + 1).getName());
        }
    }


    public static void responseResetOfMatching(){
        printMessageResponse(RESPONSE_INITIALRIZE);
    }
}