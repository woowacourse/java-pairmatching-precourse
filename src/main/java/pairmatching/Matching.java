package pairmatching;

public class Matching {

    Matching() {
        OutputView.outputActions();
        String actionNumber = InputView.inputAction();
        Action.checkActionNumber(actionNumber);
    }
}
