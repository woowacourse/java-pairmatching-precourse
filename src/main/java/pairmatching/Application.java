package pairmatching;

import java.io.IOException;

import pairmatching.controller.PairMatchingController;

public class Application {
    public static void main(String[] args) {
        try {
            PairMatchingController pairMatchingController = new PairMatchingController();
            pairMatchingController.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
