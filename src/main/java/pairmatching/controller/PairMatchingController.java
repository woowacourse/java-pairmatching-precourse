package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMatchingController {
    public static void run() {
        String inputStart = InputView.startFunction();
        String inputList = InputView.chooseWhat(inputStart);
        List<String> information = InputView.splitInformation(inputList);
        System.out.println(information);
        OutputView.printRandomPairList();

    }
}
