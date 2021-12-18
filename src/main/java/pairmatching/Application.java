package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.input.ConsoleInputView;
import pairmatching.view.input.CrewNameFileInput;
import pairmatching.view.input.CrewNameInput;
import pairmatching.view.input.InputView;
import pairmatching.view.output.ConsoleOutputView;
import pairmatching.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        CrewNameInput crewNameInput = new CrewNameFileInput();
        PairMatchingController pairMatchingController
                = new PairMatchingController(inputView, outputView, crewNameInput);
        pairMatchingController.run();
    }
}
