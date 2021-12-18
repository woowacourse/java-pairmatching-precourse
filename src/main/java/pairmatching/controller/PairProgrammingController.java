package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.PairProgramming;
import pairmatching.view.InputView;

public class PairProgrammingController {

    private List<PairProgramming> pairProgrammings = new ArrayList<>();

    public PairProgrammingController() {

    }

    public void run() {

        while (true) {
            String mainFunction = InputView.mainFunction();
            if (mainFunction.equals("1")) {
                String detailedFunction = InputView.detailedFunction();
                pairProgrammings.add(new PairProgramming(detailedFunction));
            }
            if (mainFunction.equals("Q")) {
                break;
            }

        }
    }
}
