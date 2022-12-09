package pairmatching;

import static pairmatching.ControllerMapper.executeByUserChoice;

import java.io.FileNotFoundException;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public static boolean isContinue = true;

    public PairMatchingController() {
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
