package pairmatching;

import pairmatching.controller.PairMatchingController;

public class Application {
    public static void main(String[] args) {
        PairMatchingController pairMatchingController = new PairMatchingController();

        while(true) {
            int function = pairMatchingController.inputFunction();
            if(function == -1) break;

        }



    }
}
