package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.PairProgramming;
import pairmatching.domain.PairProgrammings;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairProgrammingController {

    private PairProgrammings pairProgrammings = new PairProgrammings();

    public void run() {

        while (true) {
            String mainFunction = InputView.mainFunction();
            if (mainFunction.equals("1")) {
                String detailedFunction = InputView.detailedFunction();
                pairProgrammings.enrollNewProgram(detailedFunction);
                OutputView.printPairInfo();
            }
            if (mainFunction.equals("Q")) {
                break;
            }

        }
    }
}
