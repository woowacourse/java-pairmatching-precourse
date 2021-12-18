package pairmatching;

import java.io.FileNotFoundException;
import java.io.IOException;

import pairmatching.controller.PairmatchingController;

public class Application {
    public static void main(String[] args) {
        PairmatchingController pairmatchingController = new PairmatchingController();
        pairmatchingController.run();
    }
}
