package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import pairmatching.domain.Crews;
import pairmatching.domain.MatchingChoice;
import pairmatching.domain.PairMatchingRepository;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;

public class PairMatcher implements Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final PairMatchingRepository pairMatchingRepository = new PairMatchingRepository();
    private final Crews crews;

    public PairMatcher(Crews crews) {
        this.crews = crews;
    }

    @Override
    public void execute() {
        inputView.showMatchingMenu();
        MatchingChoice matchingChoice = getMatchingChoice();
        runPairMatcher(matchingChoice);
    }

    private MatchingChoice getMatchingChoice() {
        MatchingChoice matchingChoice = getPairMatchingInput();
        if (choiceExists(matchingChoice)) {
            String choice = getNextStep();
            if (choice.equals("네")) return matchingChoice;
            else getMatchingChoice();
        }
        return matchingChoice;
    }

    private boolean choiceExists(MatchingChoice matchingChoice) {
        return pairMatchingRepository.isExistingChoice(matchingChoice);
    }

    private String getNextStep() {
        try {
            return inputView.inputRematchTry();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getNextStep();
        }
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

    private void runPairMatcher(MatchingChoice matchingChoice) {
        List<String> crewNames = crews.getMatchingCrews(matchingChoice);
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
    }
}
