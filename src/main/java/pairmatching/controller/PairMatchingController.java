package pairmatching.controller;

import java.util.List;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.domain.Pairs;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class PairMatchingController {

    private final PairMatching pairMatching;
    private Pairs pairs = new Pairs();

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
        if (function.equals("2")) {
            search();
        }
    }

    private void matching() {
        String value = Input.matching();
        List<String> names = pairMatching.matching(value);
        pairs.add(names, value);
        Output.matching(names);
        System.out.println();
    }

    private void search() {
        String value = Input.matching();
        List<String> names = pairs.getNames(value);
        Output.matching(names);
        System.out.println();
    }
}
