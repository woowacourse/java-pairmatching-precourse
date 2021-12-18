package pairmatching.controller;

import static pairmatching.utils.Constants.*;
import static pairmatching.utils.Validator.checkAvailableSelect;
import static pairmatching.view.InputViews.getMainSelect;

public class MainController {
    public static final MatchingController matchingController = new MatchingController();
    public static final InqueryController inqueryController = new InqueryController();
    public static final InitializeController initializeController = new InitializeController();

    public void run() {
        boolean flag = false;
        while (!flag) {
            try {
                String input = checkAvailableSelect(getMainSelect());
                runSelectFunction(input);
                if (input.equals(EXIT)) {
                    flag = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void runSelectFunction(String input) {
        if (input.equals(SELECT_MATCHING)) {
            matchingController.run();
        }
        if (input.equals(SELECT_INQUERY)) {
            inqueryController.run();
        }
        if (input.equals(SELECT_INITIALIZE)) {
            initializeController.run();
        }
    }
}
