package pairmatching;

import controller.MainController;
import view.OutputView;

public class Application {
    private static final OutputView outputview = new OutputView();
    public static void main(String[] args) {
        // TODO 구현 진행
        MainController mainController = new MainController();
        mainController.run();
        outputview.printCourseAndMission();
    }
}
