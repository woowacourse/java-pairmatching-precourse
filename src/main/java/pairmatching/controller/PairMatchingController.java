package pairmatching.controller;

import static pairmatching.constants.SystemConstants.*;
import static pairmatching.utils.UserChoiceValidator.validateMainMenuActionInput;
import static pairmatching.view.InputView.requestMainMenuInput;

public class PairMatchingController {

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            String userChoice = getUserInput();
            isRunning = runUserChoice(userChoice);
        }
    }

    private boolean runUserChoice(String userChoice) {
        if (userChoice.equals(EXIT_Q)) return false;

        if (userChoice.equals(ONE)) {
            // GO TO PAIR MATCHING SCREEN
        }
        if (userChoice.equals(TWO)) {
            // GO TO PAIR READ SCREEN
        }
        if (userChoice.equals(THREE)) {
            // 초기화
        }
        return true;
    }

    private String getUserInput() {
        while(true) {
            try {
                String userInput = requestMainMenuInput();
                validateMainMenuActionInput(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }
}
