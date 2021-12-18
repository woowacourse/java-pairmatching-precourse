package pairmatching.controller;

import pairmatching.model.enums.Option;

import static pairmatching.view.InputView.selectOption;

public class PairController {
    public PairController() {
    }

    public void start() {
        Option input = null;
        while (input != Option.QUIT) {
            input = selectOption();
            if (input == Option.MATCH_PAIR) {
                matchPair();
                continue;
            }
            if (input == Option.SELECT_PAIR) {
                printPair();
                continue;
            }
            if (input == Option.INITIAL_PAIR) {
                initialPair();
                continue;
            }
        }
    }

    public void matchPair() {

    }

    public void printPair() {

    }

    public void initialPair() {

    }
}
