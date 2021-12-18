package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.utils.Initializer;

public class Application {
    public static void main(String[] args) {
        Initializer.init();
        MainController mainController = new MainController();
        mainController.run();
    }
}
