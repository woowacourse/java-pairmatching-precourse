package pairmatching.controller;

import pairmatching.service.InitializeService;
import pairmatching.utils.Validate;
import pairmatching.view.InputView;

public class MainController {
    public static final Validate validate = new Validate();
    public static final MatchingController matchingController = new MatchingController();
    public static final InqueryController inqueryController = new InqueryController();
    public static final InitializeController initializeController = new InitializeController();
    public static final InputView inputView = new InputView();

    public void run() {
        boolean flag = false;
        while (!flag) {
            try {
                String input = validate.checkMissionInfo(inputView.getMainSelect());
                readSelect(input);
                if (input.equals("Q")) {
                    flag = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readSelect(String input) {
        if (input.equals("1")) {
            matchingController.run();
        }
        if (input.equals("2")) {
            inqueryController.run();
        }
        if (input.equals("3")) {
            initializeController.run();
        }
    }
}
