package pairmatching;

import pairmatching.controller.MainController;

public class Application {
    public static void main(String[] args) {
        GetFile.getBackendCrew();
        GetFile.getFrontendCrew();
        MainController mainController = MainController.getInstance();
        mainController.run();
    }

}
