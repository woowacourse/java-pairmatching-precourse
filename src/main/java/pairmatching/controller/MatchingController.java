package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;

import static pairmatching.utils.ExceptionMessage.*;
import static pairmatching.utils.Validator.*;
import static pairmatching.view.InputViews.getMainSelect;
import static pairmatching.view.InputViews.getMatchingInfo;
import static pairmatching.view.OutputViews.printMissionInfo;

public class MatchingController {
    public static final Missions missions = new Missions();

    public void run() {
        boolean flag = false;
        while (!flag) {
            try {
                printMissionInfo(missions);
                String input = getMatchingInfo();
                checkMissionInfo(input);
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkMissionInfo(String input) {
        String[] infoArr = input.split(", ");
        checkInfoCount(infoArr);
        checkCourse(infoArr[0]);
        checkLevel(infoArr[1]);
        checkMission(infoArr[1], infoArr[2]);
    }

    private void checkCourse(String course) {
        checkEachInfo(course);
        if (!Course.isExist(course)) {
            throw new IllegalArgumentException(ERROR_COURSE_NOT_EXIST);
        }
    }

    private void checkLevel(String level) {
        checkEachInfo(level);
        if (!Level.isExist(level)) {
            throw new IllegalArgumentException(ERROR_LEVEL_NOT_EXIST);
        }
    }

    private void checkMission(String level, String mission) {
        checkEachInfo(mission);
        if (missions.isExist(level, mission)) {
            throw new IllegalArgumentException(ERROR_MISSION_NOT_EXIST);
        }
    }
}
