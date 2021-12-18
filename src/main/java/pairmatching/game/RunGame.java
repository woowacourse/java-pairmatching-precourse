package pairmatching.game;

import camp.nextstep.edu.missionutils.Console;

import pairmatching.util.Constant;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.IOException;

public class RunGame {
    private static String nextStep;
    public static void run() {
        while (true){
            selectFunction();
            if (nextStep.equals("Q")) {
                break;
            }
            if (nextStep.equals("1")) {
                pairMatching();
            }
            if (nextStep.equals("2")) {
                pairLookUp();
            }
            if (nextStep.equals("3")) {
                pairInitialize();
            }
        }
    }

    private static void pairInitialize() {
        OutputView.setInitialize();
    }
    private static void pairLookUp() {
        try {
            setPairLoopUp();
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.PAIR_LOOKUP_ERROR);
            pairLookUp();
        }
    }

    private static void setPairLoopUp() {
        OutputView.askPairLookUp();
        String input = Console.readLine();
        System.out.println();
        String[] pairLookUpInfo = InputView.splitString(input);
        OutputView.resultPairLookUp(input);
    }

    public static void pairMatching() {
        try {
            setPairMatching();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(Constant.PAIR_MATCHING_ERROR);
            pairMatching();
        }
    }

    private static void setPairMatching() throws IOException {
        OutputView.askPairMatching();
        String input = Console.readLine();
        System.out.println();
        String[] pairMatchingInfo = InputView.splitString(input);
        OutputView.resultPairMatching(input);
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

