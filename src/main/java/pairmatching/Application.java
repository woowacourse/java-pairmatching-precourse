package pairmatching;

import pairmatching.controller.MainController;

import static pairmatching.repository.CrewRepository.initCrewInfo;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        initCrewInfo();
        MainController mainController = new MainController();
        mainController.run();
    }
}
