package pairmatching.controller;

import static pairmatching.controller.ControllerMapper.executeByUserChoice;

import java.io.FileNotFoundException;
import pairmatching.domain.Crews;
import pairmatching.DataLoader;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public static boolean isContinue = true;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void execute() {
        Crews crews = loadCrewNames();
        while (isContinue){
            Controller controller = getMatchingController();
            controller.execute();
        }
    }

    private Controller getMatchingController() {
        try {
            return executeByUserChoice(inputView.inputMenuChoice());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getMatchingController();
        }
    }

    private Crews loadCrewNames() {
        try {
            DataLoader dataLoader = new DataLoader();
            return dataLoader.load();
        } catch (FileNotFoundException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return loadCrewNames();
        }
    }
}
