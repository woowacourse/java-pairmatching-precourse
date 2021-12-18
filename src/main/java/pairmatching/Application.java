package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.model.MatchingHistory;
import pairmatching.model.MatchingInfo;

public class Application {
    public static void main(String[] args) {
        PairMatchingController pairMatchingController = new PairMatchingController(new MatchingHistory(),
            new MatchingInfo());
        pairMatchingController.run();
    }
}
