package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.PairMatching;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        PairMatching pairMatching = new PairMatching();
        PairMatchingController pairMatchingController = new PairMatchingController(pairMatching);
        pairMatchingController.run();
    }
}
