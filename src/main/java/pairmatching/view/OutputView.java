package pairmatching.view;

public class OutputView {
    public static void printMain() {
        System.out.println(Constant.ASK_CHOICE);
        System.out.println(Constant.CHOICE_ONE);
        System.out.println(Constant.CHOICE_TWO);
        System.out.println(Constant.CHOICE_THREE);
        System.out.println(Constant.CHOICE_FOUR);
    }

    public static void printPairMatching() {
        System.out.println(Constant.RESULT_PAIR_MATCHING);
    }

    public static void reset() {
        System.out.println(Constant.RESET);
    }
}
