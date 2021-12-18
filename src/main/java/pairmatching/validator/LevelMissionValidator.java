package pairmatching.validator;

import pairmatching.domain.Level;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.mission.MissionFactory;
import pairmatching.domain.mission.Missions;

import static pairmatching.constant.ErrorMessage.NOT_FOUND_LEVEL_MISSION_ERROR_MESSAGE;

public class LevelMissionValidator {
    public static void checkProperLevelMission(Level level, String mission) {
        Missions missions = MissionFactory.makeMissions();
        if (!missions.hasMission(level, mission)) {
            throw new IllegalArgumentException(NOT_FOUND_LEVEL_MISSION_ERROR_MESSAGE);
        }
    }
}
