package pairmatching;

import pairmatching.controller.PairMatchingController;

public class Application {
    public static void main(String[] args) {
        PairMatchingController pairMatchingController = new PairMatchingController();
        int functionNumber = pairMatchingController.scanFunctionNumber();
        pairMatchingController.matchFunction(functionNumber);
    }
}
