package pairmatching;

import static pairmatching.Constant.INITIALIZATION_PAIRS_FUNCTION;
import static pairmatching.Constant.MATCHING_FUNCTION;
import static pairmatching.Constant.QUIT_MESSAGE;
import static pairmatching.Constant.READ_PAIRS_FUNCTION;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Pair {

    List<Crew> crews;
    Matching matching;
    Announcer announcer;

    public Pair() {
        PairManager pairManager = new PairManager();
        this.crews = pairManager.registerCrews();
        matching = new Matching();
        this.announcer = new Announcer();
    }

    public void startPairing() {

        while (true) {
            String function = selectFunction();
            if (checkQuit(function)) {
                break;
            }
            performFunction(matching, function);
        }
    }

    private String selectFunction() {
        announcer.announceSelectFunction();
        return Console.readLine();
    }

    private boolean checkQuit(String function) {
        return function.equals(QUIT_MESSAGE);
    }

    private void performFunction(Matching matching, String function) {
        if (function.equals(MATCHING_FUNCTION)) {
            matching.startMatching(crews);
            return;
        }
        if (function.equals(READ_PAIRS_FUNCTION)) {
            matching.printPairs();
            return;
        }
        if (function.equals(INITIALIZATION_PAIRS_FUNCTION)) {
            matching.removePairs();
        }
    }
}
