package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.function.Supplier;

public abstract class Controller {

    protected InputView inputView;
    protected OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public abstract void run();

    protected <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException error) {
            printError(error);
            return repeat(inputReader);
        }
    }

    private void printError(Exception error) {
        outputView.printError(error);
    }
}
