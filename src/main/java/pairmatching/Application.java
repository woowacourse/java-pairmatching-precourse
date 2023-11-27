package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.repository.MatchingResultRepository;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MatchingController matchingController = new MatchingController(
                new InputView(),
                new OutputView(),
                new MatchingService(new MatchingResultRepository())
        );

        matchingController.play();
    }
}
