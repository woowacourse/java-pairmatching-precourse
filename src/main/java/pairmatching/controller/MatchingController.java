package pairmatching.controller;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Missions;
import pairmatching.utils.Validate;
import pairmatching.view.OutputView;

import static pairmatching.utils.ExceptionMessage.*;
import static pairmatching.utils.Validate.checkEachInfo;
import static pairmatching.utils.Validate.checkInfoCount;
import static pairmatching.view.InputView.getMatchingInfo;

public class MatchingController {
    public static final OutputView outputView = new OutputView();
    public static final Missions missions = new Missions();
    public static final Validate validate = new Validate();
    public void run() {
        boolean flag = false;
        while(!flag) {
            try {
                outputView.printMissionInfo(missions);
                String input = getMatchingInfo();
                validate.checkMissionInfo(input);
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
        if (!missions.isExist(level, mission)) {
            throw new IllegalArgumentException(ERROR_MISSION_NOT_EXIST);
        }
    }
}
