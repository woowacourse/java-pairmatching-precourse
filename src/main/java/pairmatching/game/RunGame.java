package pairmatching.game;

import camp.nextstep.edu.missionutils.Console;

import pairmatching.util.Constant;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class RunGame {
    private static String nextStep;
    public static void run() {
        while (true){
            selectFunction();
            if (nextStep.equals("Q")) {
                break;
            }
        }
    }

    private static void selectFunction() {
        try {
            setFunction();
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.SELECT_FUNCTION_ERROR);
            selectFunction();
        }

    }

    private static void setFunction() {
        OutputView.askFunction();
        String input = Console.readLine();
        System.out.println();
        nextStep = InputView.isValidSelect(input);
    }
}

