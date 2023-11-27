package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.view.InputView;

public class Application {
    private static final MatchingController matchingController = new MatchingController();
    private static final InputView inputView = new InputView();


    public static void main(String[] args) {
        String menu;
        do {
            menu = inputView.getMenu();
            if (menu.equals("1")) {
                matchingController.createPair();
            }
            if (menu.equals("2")) {
                matchingController.readPair();
            }
            if (menu.equals("3")) {
                matchingController.resetPair();
            }
            //todo 어짜피 보장된 값만 받을거임

        } while (!menu.equals("Q"));
    }
}
