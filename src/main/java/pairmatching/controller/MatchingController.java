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

    public static boolean existsDuplicatedPair(Mission mission) {
        return missionSet.findDuplicated(mission);
    }

    public static void removeMission(MissionName missionName) {
        missionSet.removeMission(missionName);
    }

    public static String getMissionResult(MissionName name) {
        return missionSet.getMissionResult(name);
    }

    public static boolean hasMission(MissionName input) {
        return missionSet.hasMissionByName(input);
    }

    public static void clear() {
        missionSet.clear();
    }
}
