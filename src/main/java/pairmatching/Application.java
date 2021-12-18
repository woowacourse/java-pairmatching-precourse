package pairmatching;

import java.io.IOException;

import pairmatching.controller.MainController;
import pairmatching.initialize.CrewInitialize;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        CrewInitialize.readFiles();
        MainController mainController = new MainController();
        mainController.inputMenu();
    }
}
