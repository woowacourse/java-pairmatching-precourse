package pairmatching;

import pairmatching.controller.PairMatchingController;

public class Application {
    public static void main(String[] args) {
        PairMatchingController pairMatchingController = new PairMatchingController();
        while(true) {
            int number = pairMatchingController.inputFunctionNumber();
            if(number == -1) break;

            if(number == 1) {
                pairMatchingController.match();
            }

            if(number == 2) {
                pairMatchingController.search();
            }

            if(number == 3) {
                pairMatchingController.initialize();
            }

        }

    }
}
