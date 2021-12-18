package pairmatching.controller;

import pairmatching.domain.*;
import pairmatching.service.MatchingSercive;

import static pairmatching.utils.ExceptionMessage.*;
import static pairmatching.utils.Validator.*;
import static pairmatching.view.InputViews.*;
import static pairmatching.view.OutputViews.printMatchPair;
import static pairmatching.view.OutputViews.printMissionInfo;

public class MatchingController {
    public static final Missions missions = new Missions();
    static final MatchingSercive matchingService = new MatchingSercive();

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
        }
        printMatchPair(matchingService.matchAndSavePair(course, level, mission));
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
