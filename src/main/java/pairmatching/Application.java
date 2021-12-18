package pairmatching;

import pairmatching.controller.PairmatchingController;

public class Application {
    private static PairmatchingController pairmatchingController;

    public static void main(String[] args) {
        init();
        run();
    }

    private static void init() {
        pairmatchingController = new PairmatchingController();
    }

    private static void run() {
        pairmatchingController.run();
    }
}
