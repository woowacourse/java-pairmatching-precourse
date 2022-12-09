package pairmatching.controller;

import pairmatching.domain.Crews;
import pairmatching.domain.MatchingChoice;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;

public class PairMatcher implements Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Crews crews;

    public PairMatcher(Crews crews) {
        this.crews = crews;
    }

    @Override
    public void execute() {
        MatchingChoice matchingChoice = getPairMatchingInput();
        // runPairMatcher(matchingChoice); //이미 record에 존재하는가?
    }

    private MatchingChoice getPairMatchingInput() {
        try {
            String input = inputView.inputPairMatching();
            return new MatchingChoice(input);
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getPairMatchingInput();
        }
    }
}
