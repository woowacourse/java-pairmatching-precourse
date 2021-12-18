package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchResult;
import pairmatching.domain.MatchResultRepository;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.Pair;
import pairmatching.utils.OptionInputUtils;

import java.util.List;

import static pairmatching.constants.SystemConstants.*;
import static pairmatching.utils.PairMatchUtils.returnMatchResult;
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

        String[] optionInfos = optionsInput.split(OPTION_SEPARATOR);
        Course course = OptionInputUtils.courseNameToDomain(optionInfos[0]);
        Level level = OptionInputUtils.levelNameToDomain(optionInfos[1]);
        Mission mission = MissionRepository.getMissionByName(optionInfos[2]);

        List<Pair> pairs = returnMatchResult();

        MatchResultRepository.addMatchResult(new MatchResult(course, level, mission, pairs));
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
