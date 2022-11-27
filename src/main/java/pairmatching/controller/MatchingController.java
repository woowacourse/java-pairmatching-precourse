package pairmatching.controller;

import pairmatching.domain.*;
import pairmatching.service.MatchingService;


import static pairmatching.utils.Validate.checkInfoCount;
import static pairmatching.utils.Validate.checkRematchAnswer;
import static pairmatching.view.InputView.getConfirmRematch;
import static pairmatching.view.InputView.getMatchingInfo;
import static pairmatching.view.OutputView.printMatchPair;
import static pairmatching.view.OutputView.printMissionInfo;

public class MatchingController {
    public static final Missions missions = new Missions();
    public static final MatchingService matchingService = new MatchingService();

    public void run() {
        boolean flag = false;
        while (!flag) {
            try {
                printMissionInfo(missions);
                String input = getMatchingInfo();
                matchPair(input, missions);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void matchPair(String input, Missions missions) {
        String[] infoArr = input.split(", ");
        checkInfoCount(infoArr);
        Course course = matchingService.checkCourse(infoArr[0]);
        Level level = matchingService.checkLevel(infoArr[1]);
        Mission mission = matchingService.checkMission(infoArr[1], infoArr[2], missions);

        if (matchingService.checkExistPair(course,level,mission)) {
            if (!getRematchAnswer()) {
                return;
            }
            printMatchPair(matchingService.rematchAndSavePair(course, level, mission));
            return;
        }
        printMatchPair(matchingService.firstMatch(course, level, mission));
    }

    public boolean getRematchAnswer() {
        boolean flag = false;
        while (!flag) {
            try {
                String input = checkRematchAnswer(getConfirmRematch());
                if (input.equals("아니요")) {
                    return false;
                }
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }
}
