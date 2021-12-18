package pairmatching;

import pairmatching.controller.PairController;
import pairmatching.model.enums.Option;

import static pairmatching.view.InputView.selectOption;

public class Application {
    public static void main(String[] args) {
        PairController controller = new PairController();
        Option input = null;
        while (input != Option.QUIT) {
            input = selectOption();
            if (input == Option.MATCH_PAIR) {
                controller.selectMatchPair();
                continue;
            }
            if (input == Option.SELECT_PAIR) {
                controller.printPair();
                continue;
            }
            if (input == Option.INITIAL_PAIR) {
                controller.initialPair();
            }
        }
    }
}
