package pairmatching.controller;

import java.util.List;

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
            selectFunction(function);
        } while (!function.equals("Q"));
    }

    private void selectFunction(String function) {
        if (function.equals("1")) {
            Output.LIST();
            matching();
        }
        if (function.equals("2")) {
            System.out.println();
            search();
        }
        if (function.equals("3")) {
            reset();
        }
        if (function.equals("Q")) {
            return;
        }
    }

    private void matching() {
        try {
            String value = Input.matching();
            if (pairs.getNames(value) != null) {
                notFirstMatching(value);
            }
            if (pairs.getNames(value) == null) {
                firstMatching(value);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void firstMatching(String value) {
        pairMatching.validate(value);
        List<String> names = pairMatching.matching(value);
        pairs.add(names, value);
        Output.matching(names);
        System.out.println();
    }

    private void notFirstMatching(String value) {
        if (Input.rematching().equals("아니오")) {
            matching();
        }
    }

    private void search() {
        try {
            String value = Input.matching();
            pairs.validate(value);
            pairMatching.validate(value);
            List<String> names = pairs.getNames(value);
            Output.matching(names);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void reset() {
        pairs = new Pairs();
        Output.reset();
    }
}
