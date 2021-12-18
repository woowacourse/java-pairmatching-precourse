package pairmatching;

import pairmatching.controller.PairMachineController;

public class Application {
    public static void main(String[] args) {
        PairMachineController controller = new PairMachineController();
        controller.run();
    }
}