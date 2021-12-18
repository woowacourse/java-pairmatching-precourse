package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.controller.MatchingControllerImpl;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        MatchingController matchingController = new MatchingControllerImpl();
        matchingController.run();
    }

}
