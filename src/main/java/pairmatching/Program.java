package pairmatching;

import pairmatching.view.Constant;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Program {
    public static boolean again = true;

    public static boolean on() {
        return again;
    }

    public static void choiceMain() {
        String choice = InputView.askMain();
        if (choice.equals(Constant.ONE)) {

        }
        if (choice.equals(Constant.TWO)) {

        }
        if (choice.equals(Constant.THREE)) {

        }
        if (choice.equals(Constant.Q)) {
            again = false;
        }
    }

    public static void choiceCategory() {
        OutputView.printMenu();
    }
}
