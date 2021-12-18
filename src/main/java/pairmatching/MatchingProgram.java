package pairmatching;

import static camp.nextstep.edu.missionutils.Console.*;

public class MatchingProgram {
    private boolean KEEP_MATCHING = true;
    private MatchingInfoSet matchingInfoSet = new MatchingInfoSet();

    public MatchingProgram() {
        initiateProgram();
        while (KEEP_MATCHING) {
            getAndPerformFunction();
        }
    }

    private void initiateProgram(){
        Level.LEVEL1.addMission("자동차경주");
        Level.LEVEL1.addMission("로또");
        Level.LEVEL1.addMission("숫자야구게임");
        Level.LEVEL2.addMission("장바구니");
        Level.LEVEL2.addMission("결제");
        Level.LEVEL2.addMission("지하철노선도");
        Level.LEVEL4.addMission("성능개선");
        Level.LEVEL4.addMission("배포");

        System.out.println("initiate program");
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
                System.out.println("[ERROR] 과정, 레벨, 미션 형식에 맞게 입력해주세요.");
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
                System.out.println("[ERROR] 과정, 레벨, 미션 형식에 맞게 입력해주세요.");
            }
        }
    }

    private void pairInitializing() {
        matchingInfoSet.initializeAllPairMatching();
    }

    private void quitProgram() {
        KEEP_MATCHING = false;
    }

}
