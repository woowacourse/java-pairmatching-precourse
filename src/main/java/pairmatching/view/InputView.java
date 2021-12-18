package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String askMain() {
        OutputView.printMain();
        return Console.readLine();
    }

    public static String askCategory() {
        System.out.println(Constant.ASK_PAIR);
        System.out.println(Constant.EX);
        return Console.readLine();
    }

    public static String askRePairMatching() {
        System.out.println(Constant.RE_PAIR_MATCHING);
        System.out.println(Constant.Y_N);
        return Console.readLine();
    }
}
