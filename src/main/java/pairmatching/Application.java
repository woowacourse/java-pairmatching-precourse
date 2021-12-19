package pairmatching;

import pairmatching.controller.MatcherController;

public class Application {
    public static void main(String[] args) {
        MatcherController matcherController = new MatcherController();
        matcherController.operate();
    }
}