package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.serivce.PairMatching;

public class Application {
    public static void main(String[] args) {
        PairMatching pairMatching = new PairMatching();
        PairMatchingController controller = new PairMatchingController(pairMatching);
        controller.start();
    }
}
