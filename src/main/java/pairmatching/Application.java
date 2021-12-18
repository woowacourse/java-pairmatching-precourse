package pairmatching;

import pairmatching.controller.PairController;

public class Application {
    public static void main(String[] args) {
        PairController pairController = new PairController();
        pairController.run();
    }
}
