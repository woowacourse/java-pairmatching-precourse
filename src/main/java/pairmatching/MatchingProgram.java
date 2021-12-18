package pairmatching;

import static camp.nextstep.edu.missionutils.Console.*;

public class MatchingProgram {
    private boolean KEEP_MATCHING = true;
    private MatchingInfoSet matchingInfoSet = new MatchingInfoSet();

    public MatchingProgram() {
        while (KEEP_MATCHING) {
            getAndPerformFunction();
        }
    }

    private void getAndPerformFunction() {
        MessagePrinter.printFunctions();
        while (true) {
            try {
                String function = readLine();
                performFunctionOf(function);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 없는 기능입니다!");
            }
        }
    }

    private void performFunctionOf(String function) {
        if (function.equals("1")) {
            pairMatching();
            return;
        }
        if (function.equals("2")) {
            pairViewing();
            return;
        }
        if (function.equals("3")) {
            pairInitializing();
            return;
        }
        if (function.equals("Q")) {
            quitProgram();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void pairMatching() {
        MessagePrinter.printMissions();
        while (true) {
            try {
                String mission = readLine();
                matchingInfoSet.performPairMatching(mission);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 존재하는 과정, 레벨, 미션을 형식에 맞게 입력하세요.");
            }
        }
    }

    private void pairViewing() {
        MessagePrinter.printMissions();
        while (true) {
            try {
                String mission = readLine();
                matchingInfoSet.viewPairMatching(mission);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 존재하는 과정, 레벨, 미션을 형식에 맞게 입력하세요.");
            }
        }
    }

    private void pairInitializing() {

        System.out.println("pairInitializing");
    }

    private void quitProgram() {
        KEEP_MATCHING = false;
    }

}
