package pairmatching.controller;

import static pairmatching.utils.UserChoiceValidator.validateMainMenuActionInput;
import static pairmatching.view.InputView.requestMainMenuInput;

public class PairMatchingController {

    public void run() {
        String userInput = requestMainMenuInput();
        validateMainMenuActionInput(userInput);
    }
}
