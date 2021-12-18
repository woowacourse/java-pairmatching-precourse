package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResultRepository;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.Pair;
import pairmatching.domain.PairHistory;
import pairmatching.domain.PairHistoryRepository;
import pairmatching.utils.OptionInputUtils;

import java.util.List;

import static pairmatching.constants.ExceptionMessages.NO_MATCHING_RESULT_EXCEPTION;
import static pairmatching.constants.SystemConstants.*;
import static pairmatching.utils.PairMatchUtils.returnMatchResult;
import static pairmatching.utils.UserChoiceValidator.*;
import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

public class PairMatchingService {

    public void run() {
        showBackgroundInfo();
        postNewMatchResult();
    }

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

    public void postNewMatchResult() {
        String optionsInput = requestPairMatchingOptionsInput();
        MatchResult existingResult = MatchResultRepository.getMatchResultByOptions(optionsInput);
        if (!confirmPostNewMatchResult(existingResult)) {
            return;
        }

        String[] optionInfos = optionsInput.split(OPTION_SEPARATOR);
        Course course = OptionInputUtils.courseNameToDomain(optionInfos[0]);
        Level level = OptionInputUtils.levelNameToDomain(optionInfos[1]);
        Mission mission = MissionRepository.getMissionByName(optionInfos[2]);

        List<Pair> pairs = returnMatchResult();
        MatchResult matchResult = new MatchResult(course, level, mission, pairs);
        MatchResultRepository.addMatchResult(matchResult);
        saveAllPairHistory(pairs, level);
        showMatchResult(matchResult);
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

    public void saveAllPairHistory(List<Pair> pairs, Level level) {
        for (Pair pair : pairs) {
            PairHistoryRepository.addPairHistory(new PairHistory(pair.getCrews(), level));
        }
    }
}
