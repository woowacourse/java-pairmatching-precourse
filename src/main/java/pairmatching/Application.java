package pairmatching;

import controller.MainController;
import view.InputView;
import view.OutputView;

public class Application {
    private static final InputView inputview = new InputView();
    private static final OutputView outputview = new OutputView();
    private static final MainController mainController = new MainController();
    public static void main(String[] args) {
        // TODO 구현 진행
        try {
            init();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        outputview.printCourseAndMission();
    }
    private static void init() {
        outputview.printSelectFunction();
        String input = inputview.readSelect();
        mainController.mainSelect(input);
    }
}
