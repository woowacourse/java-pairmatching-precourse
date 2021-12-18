package pairmatching;

import java.util.List;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        PairMatchingController pairMatchingController = new PairMatchingController();
        pairMatchingController.init();
        pairMatchingController.run();
    }
}
