package pairmatching.controller;

import pairmatching.domain.CrewList;
import pairmatching.domain.MatchingService;
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
            if (userChoice.equals(PAIR_MATCHING_NUMBER)) {
                String processLevelMission = InputView.getProcessLevelMission();
                String[] split = processLevelMission.split(SPLIT_DELIMITER);
                choicePairMatching(split[PROCESS], split[LEVEL], split[MISSION]);
            }
        }
    }

    public void choicePairMatching(String processName, String levelName, String missionName) {
        try {
            CrewList match = frontMatchingService.match(processName, levelName, missionName);
            OutputView.printProcess();
            OutputView.printMatchingResult(match);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
