package pairmatching;

import java.util.ArrayList;

public class OutputView {
    public static String DASH_LINE = "#############################################";
    public static String PRINT_ACTION_MESSAGE = "기능을 선택하세요.";
    public static String PRINT_PAIR_RESULT_MESSAGE = "\n페어 매칭 결과입니다.";

    public static void outputActions() {
        System.out.println(PRINT_ACTION_MESSAGE);
        for (Action action : Action.values()) {
            System.out.println(action.getName());
        }
    }

    public static void outputCourse() {
        System.out.println(DASH_LINE);
        System.out.println("과정 : " + Course.BACKEND.getName() + "|" + Course.FRONTEND.getName());
        System.out.println("미션:");
        for (Level level : Level.values()) {
            System.out.print("- " + level.getName() + ":");
            System.out.println(Level.getMissionsByLevel(level.getMissionNumber()));
        }
        System.out.println(DASH_LINE);
    }

    public static void printPairResult(ArrayList<Pair> pairList) {
        System.out.println(PRINT_PAIR_RESULT_MESSAGE);
        for (Pair pair : pairList) {
            if (!pair.isCrew3Empty()) {
                System.out.println(pair.getCrew1() + " : " + pair.getCrew2() + " : " +pair.getCrew3());
            }
            if (pair.isCrew3Empty()) {
                System.out.println(pair.getCrew1() + " : " + pair.getCrew2());
            }
        }
    }
}
