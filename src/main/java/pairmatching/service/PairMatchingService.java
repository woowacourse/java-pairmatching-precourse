package pairmatching.service;

import pairmatching.domain.Level;
import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResultRepository;
import pairmatching.domain.Pair;
import pairmatching.domain.PairHistory;
import pairmatching.domain.PairHistoryRepository;

import java.util.List;

import static pairmatching.constants.ExceptionMessages.NO_MATCHING_RESULT_EXCEPTION;
import static pairmatching.constants.SystemConstants.*;
import static pairmatching.utils.PairMatchUtils.returnMatchResult;
import static pairmatching.utils.PairMatchUtils.validateNoDuplicateHistory;
import static pairmatching.utils.UserChoiceValidator.*;
import static pairmatching.view.InputView.*;
import static pairmatching.view.InputView.requestRetryPairMatchInput;
import static pairmatching.view.OutputView.*;

public class PairMatchingService {

    public void readMatchResult() {
        showBackgroundInfo();
        String optionsInput = requestPairMatchingOptionsInput();
        MatchResult matchResult = MatchResultRepository.getMatchResultByOptions(optionsInput);
        if (matchResult == null) {
            System.out.println(NO_MATCHING_RESULT_EXCEPTION);
            return;
        }
        showMatchResult(matchResult);
    }

    public void postMatchResult() {
        boolean isRunning = true;
        while (isRunning) {
            showBackgroundInfo();
            String optionsInput = requestPairMatchingOptionsInput();

            MatchResult existingResult = MatchResultRepository.getMatchResultByOptions(optionsInput);
            if (!confirmPostNewMatchResult(existingResult)) break;
            isRunning = postMatchResultWithOptions(optionsInput);
        }
    }

    public boolean postMatchResultWithOptions(String optionsInput) {
        while (true) {
            MatchResult matchResult = generateValidMatchResult(optionsInput);
            if (matchResult == null) {
                if (checkContinuePostMatchResult()) continue;
                return true;
            }
            saveValidMatchResult(matchResult);
            return false;
        }
    }

    public boolean checkContinuePostMatchResult() {
        while(true) {
            try {
                String userChoice = requestRetryPairMatchInput();
                validateYesNoInput(userChoice);
                if (userChoice.equals(YES)) return true;
                if (userChoice.equals(NO)) return false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private MatchResult generateValidMatchResult(String optionsInput) {
        int trialNum = 0;
        while (trialNum < 3) {
            List<Pair> pairs = returnMatchResult();
            MatchResult matchResult = new MatchResult(optionsInput, pairs);
            boolean isValid = validateNoDuplicateHistory(pairs, matchResult.getLevel());
            if (isValid) return matchResult;
            trialNum++;
        }
        return null;
    }

    private void saveValidMatchResult(MatchResult matchResult) {
        MatchResultRepository.addMatchResult(matchResult);
        saveAllPairHistory(matchResult.getPairs(), matchResult.getLevel());
        showMatchResult(matchResult);
    }

    public boolean confirmPostNewMatchResult(MatchResult existingResult) {
        if (existingResult == null) return true;
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

    public void saveAllPairHistory(List<Pair> pairs, Level level) {
        for (Pair pair : pairs) {
            PairHistoryRepository.addPairHistory(new PairHistory(pair.getCrews(), level));
        }
    }
}
