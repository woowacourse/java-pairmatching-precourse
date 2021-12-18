package pairmatching.controller;

import pairmatching.domain.CrewList;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingService;
import pairmatching.validator.InputViewValidator;
import pairmatching.validator.LevelMissionValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.IOException;

import static pairmatching.constant.SystemMessage.*;

public class Controller {
    private MatchingService frontMatchingService = new MatchingService(FRONT_END);
    private MatchingService backMatchingService = new MatchingService(BACK_END);

    public void run() {
        while (true) {
            String userChoice = InputView.getUserChoice();
            InputViewValidator.checkUserChoice(userChoice);
            if (userChoice.equals(PAIR_MATCHING_NUMBER)) {
                OutputView.printProcess();
                String processLevelMission = InputView.getProcessLevelMission();
                InputViewValidator.checkProcessLevelMission(processLevelMission);
                String[] split = processLevelMission.split(SPLIT_DELIMITER);
                LevelMissionValidator.checkProperLevelMission(Level.getLevel(split[LEVEL]), split[MISSION]);
                choicePairMatching(split[PROCESS], split[LEVEL], split[MISSION]);
            }
        }
    }

    public void choicePairMatching(String processName, String levelName, String missionName) {
        CrewList match = frontMatchingService.match(processName, levelName, missionName);
        OutputView.printMatchingResult(match);

    }
}
