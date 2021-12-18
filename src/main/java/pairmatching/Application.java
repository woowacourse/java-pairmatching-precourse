package pairmatching;

import java.io.IOException;

import pairmatching.controller.PairMatchingController;

public class Application {
    public static void main(String[] args) throws IOException {
        PairMatchingController pairMatchingController = new PairMatchingController();
        pairMatchingController.run();
    }
}
