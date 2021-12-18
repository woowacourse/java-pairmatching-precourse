package pairmatching;

import java.io.IOException;

import pairmatching.controller.MainController;

public class Application {
    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        mainController.run();
    }
}
