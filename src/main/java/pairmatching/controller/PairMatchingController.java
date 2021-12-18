package pairmatching.controller;

import java.util.List;

import pairmatching.domain.PairMatching;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class PairMatchingController {

    private final PairMatching pairMatching;
    private List<String> names;

    public PairMatchingController(PairMatching pairMatching) {
        this.pairMatching = pairMatching;
    }

    public void run() {
        String function;
        do {
            function = Input.function();
            //validate();
            selectFunction(function);
        } while (!function.equals("Q"));
    }

    private void selectFunction(String function) {
        if (function.equals("1")) {
            matching();
        }
    }

    private void matching() {
        String value = Input.matching();
        names = pairMatching.matching(value);
        Output.matching(names);
        System.out.println();
    }
}
