package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.domain.course.Course;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.mission.MissionName;
import pairmatching.domain.mission.MissionSet;

public class MatchingController {
    private static MissionSet missionSet = MissionSet.getInstance();

    public static void makeMission(Course course, Level level, MissionName missionName) {
        missionSet.addMission(Mission.of(course, level, missionName));
    }


    public static boolean hasMission(Level level, MissionName missionName) {
        return missionSet.hasMissionInSameLevel(level, missionName);
    }
}
