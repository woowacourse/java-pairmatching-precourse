package pairmatching;

import static pairmatching.Constant.INITIALIZATION_PAIRS_FUNCTION;
import static pairmatching.Constant.MATCHING_FUNCTION;
import static pairmatching.Constant.QUIT_MESSAGE;
import static pairmatching.Constant.READ_PAIRS_FUNCTION;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Pair {

    List<Crew> crews;

    public Pair() {
        PairManager pairManager = new PairManager();
        this.crews = pairManager.registerCrews();
    }

    public void startPairing() {
        Matching matching = new Matching();
        while (true) {
            String function = selectFunction();
            if (checkQuit(function)) {
                break;
            }
            performFunction(matching, function);
        }
    }

    private String selectFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료");
        return Console.readLine();
    }

    private boolean checkQuit(String function) {
        return function.equals(QUIT_MESSAGE);
    }

    private void performFunction(Matching matching, String function) {
        if (function.equals(MATCHING_FUNCTION)) {
            matching.startMatching();
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
