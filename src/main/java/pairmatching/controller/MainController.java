package pairmatching.controller;

import static pairmatching.utils.Validator.checkAvailableSelect;
import static pairmatching.view.InputViews.getMainSelect;

public class MainController {
    public static final MatchingController matchingController = new MatchingController();

    public void run() {
        boolean flag = false;
        while (!flag) {
            try {
                String input = checkAvailableSelect(getMainSelect());
                runSelectFunction(input);
                if (input.equals("Q")) {
                    flag = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void runSelectFunction(String input) {
        if (input.equals("1")) {
            matchingController.run();
        }
        if (input.equals("2")) {

        }
        if (input.equals("3")) {

        }
    }
}
