package pairmatching.domain;

import java.io.IOException;

import pairmatching.view.InputView;

public class PairMatchingProgram {

    public void start() throws IOException {
        InputView inputView = new InputView();
        inputView.inputFunction();
    }
}
