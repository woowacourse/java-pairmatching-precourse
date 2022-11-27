package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import static pairmatching.repository.CrewRepository.initCrewInfo;

public class Application {
    private static final MainController mainController = new MainController();
    public static void main(String[] args) {
        // TODO 구현 진행
        initCrewInfo();
        mainController.run();
    }
}
