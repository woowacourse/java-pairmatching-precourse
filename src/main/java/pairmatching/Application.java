package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    private static final MatchingController matchingController = new MatchingController();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();


    public static void main(String[] args) {
        String menu;
        do {
            menu = inputView.getMenu();
            if (menu.equals("1")) {
                handle(matchingController::createPair);
            }
            if (menu.equals("2")) {
                handle(matchingController::readPair);
            }
            if (menu.equals("3")) {
                handle(matchingController::resetPair);
            }
            //todo 어짜피 보장된 값만 받을거임

        } while (!menu.equals("Q"));
    }

    private static void handle(Runnable runnable){
        try{
            runnable.run();
        } catch (IllegalArgumentException e){
            outputView.printErrorMessage(e);
        } finally {
            outputView.newLine();
        }
    }
}
