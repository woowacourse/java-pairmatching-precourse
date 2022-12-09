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
        loadCrewNames();
    }

    private void loadCrewNames() {
        try {
            DataLoader dataLoader = new DataLoader();
            dataLoader.load();
        } catch (FileNotFoundException exception) {
            // 에러 출력
        }
    }
}
