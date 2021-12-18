package pairmatching.service;

import static pairmatching.view.InputView.*;

public class PairMatchingService {

    public void run() {
        showBackgroundInfo();
        postNewPairs();
    }

    public void postNewPairs() {
        String optionsInput = requestPairMatchingOptionsInput();
    }
}
