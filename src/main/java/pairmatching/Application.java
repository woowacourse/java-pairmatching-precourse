package pairmatching;

import java.io.FileNotFoundException;

import pairmatching.controller.PairmatchingController;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        PairmatchingController pairmatchingController = new PairmatchingController();
        pairmatchingController.run();
    }
}
