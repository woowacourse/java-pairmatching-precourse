package pairmatching;

import pairmatching.controller.Controller;
import pairmatching.domain.MatchingService;
import pairmatching.view.OutputView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
