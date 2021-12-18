package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.domain.course.Course;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.mission.MissionName;
import pairmatching.domain.mission.MissionSet;

import java.util.List;

public class MatchingController {
    private static MissionSet missionSet = MissionSet.getInstance();

    public static void makeMission(Course course, Level level, MissionName missionName, List<String> nameList) {
        missionSet.addMission(Mission.of(course, level, missionName, nameList));
    }


    public static boolean hasMission(Level level, MissionName missionName) {
        return missionSet.hasMissionInSameLevel(level, missionName);
    }
}
