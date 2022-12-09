package pairmatching;

import java.io.FileNotFoundException;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void execute() {
        Crews crews = loadCrewNames();
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
