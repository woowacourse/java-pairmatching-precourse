package pairmatching.controller;

import pairmatching.crew.CrewRepository;
import pairmatching.crew.Position;
import pairmatching.matcher.PairMatcher;
import pairmatching.mission.Level;
import pairmatching.mission.Mission;
import pairmatching.mission.MissionRepository;

public class PariMatchingController {

    private static final String ERR_INVALID_LEVEL = "레벨이 일치하지 않습니다.";
    private final PairMatcher pairMatcher = new PairMatcher();

    public void matchPair(String missionName, String positionName, String levelName) {
        Mission mission = MissionRepository.findByName(missionName);
        Level level = Level.of(levelName);
        Position position = Position.of(positionName);
        validateLevelMatched(mission, level);
        if (position == Position.BACKEND) {
            pairMatcher.matchPairs(mission, CrewRepository.getBackendCrews(), Position.BACKEND);
            return;
        }
        pairMatcher.matchPairs(mission, CrewRepository.getFrontendCrews(), Position.FRONTEND);
    }

    public String getResult(String missionName, String positionName, String levelName) {
        Mission mission = getMission(missionName, levelName);
        return mission.getMatchedResult(Position.of(positionName));
    }

    public Mission getMission(String missionName, String levelName) {
        Mission mission = MissionRepository.findByName(missionName);
        Level level = Level.of(levelName);
        validateLevelMatched(mission, level);
        return mission;
    }

    private void validateLevelMatched(Mission mission, Level level) {
        if (mission.getLevel() != level) {
            throw new IllegalArgumentException(ERR_INVALID_LEVEL);
        }
    }
}
