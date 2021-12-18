package pairmatching.service;

import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResultRepository;

import static pairmatching.constants.SystemConstants.*;
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
            String userChoice = requestNewMatchInput();
            if (userChoice.equals(YES)) return true;
            if (userChoice.equals(NO)) return false;
        }
    }
}
