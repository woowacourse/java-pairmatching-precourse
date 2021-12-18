package pairmatching;

import pairmatching.controller.PairMatchingController;

public class Application {
    private static String functionNumber;

    public static void main(String[] args) {
        PairMatchingController pairMatchingController = new PairMatchingController();
        while (true) {
            String functionNumber = pairMatchingController.scanFunctionNumber();
            if (functionNumber.equals("Q")) {
                break;
            }
        }
        pairMatchingController.matchFunction(Integer.parseInt(functionNumber));
    }
}
