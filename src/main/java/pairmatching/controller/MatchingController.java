package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;
import pairmatching.service.MatchingSercive;

import static pairmatching.utils.Constants.*;
import static pairmatching.utils.Validator.checkInfoCount;
import static pairmatching.utils.Validator.checkRematchAnswer;
import static pairmatching.view.InputViews.getConfirmRematch;
import static pairmatching.view.InputViews.getMatchingInfo;
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
        String[] infoArr = input.split(ITEM_SEPORATOR);
        checkInfoCount(infoArr);
        Course course = matchingService.checkCourse(infoArr[COURSE_INDEX]);
        Level level = matchingService.checkLevel(infoArr[LEVEL_INDEX]);
        Mission mission = matchingService.checkMission(infoArr[LEVEL_INDEX], infoArr[MISSION_INDEX], missions);

        if (matchingService.checkExistPair(course, level, mission)) {
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
                if (input.equals(ANSWER_NO)) {
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
