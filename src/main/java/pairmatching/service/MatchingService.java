package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;

import static pairmatching.utils.ExceptionMessage.*;
import static pairmatching.utils.Validate.checkEachInfo;
import static pairmatching.utils.Validate.checkInfoCount;

public class MatchingService {


    public void checkMissionInfo(String input, Missions missions) {
        String[] infoArr = input.split(", ");
        checkInfoCount(infoArr);
        checkCourse(infoArr[0]);
        checkLevel(infoArr[1]);
        checkMission(infoArr[1], infoArr[2], missions);
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

    private void checkMission(String level, String mission, Missions missions) {
        checkEachInfo(mission);
        if (!missions.isExist(level, mission)) {
            throw new IllegalArgumentException(ERROR_MISSION_NOT_EXIST);
        }
    }
}