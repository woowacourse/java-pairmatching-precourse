package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.service.MatchingService;

public class Application {
    public static void main(String[] args) {
        MatchingService matchingService = new MatchingService();
        PairMatchingController pairMatchingController = new PairMatchingController(matchingService);
        pairMatchingController.run();
    }
}
