package pairmatching.controller;

import pairmatching.view.MatchingView;

public class MatchingController {
    private static MatchingController instance;

    public static MatchingController getInstance() {
        if (instance == null) {
            instance = new MatchingController();
        }
        return instance;
    }

    public void run() {
        MatchingView.printMatchingPrompt();
    }
}
