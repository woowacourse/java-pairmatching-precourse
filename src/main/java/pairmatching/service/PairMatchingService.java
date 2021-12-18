package pairmatching.service;

import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResultRepository;

import static pairmatching.constants.SystemConstants.*;
import static pairmatching.utils.UserChoiceValidator.*;
import static pairmatching.view.InputView.*;

public class PairMatchingService {

    public void run() {
        showBackgroundInfo();
        postNewMatchResult();
    }

    public void postNewMatchResult() {
        String optionsInput = requestPairMatchingOptionsInput();
        MatchResult existingResult = MatchResultRepository.getMatchResultByOptions(optionsInput);
        if (!confirmPostNewMatchResult(existingResult)) {
            return;
        }
        // actually Post
    }

    public boolean confirmPostNewMatchResult(MatchResult existingResult) {
        if (existingResult != null) return true;
        while(true) {
            try {
                String userChoice = requestNewMatchInput();
                validateYesNoInput(userChoice);
                if (userChoice.equals(YES)) return true;
                if (userChoice.equals(NO)) return false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
