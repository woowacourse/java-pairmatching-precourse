package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.service.PeopleService;

public class Application {
    public static void main(String[] args) {
        PeopleService peopleService = new PeopleService();
        PairMatchingController pairMatchingController = new PairMatchingController(peopleService);
        pairMatchingController.run();
    }
}
