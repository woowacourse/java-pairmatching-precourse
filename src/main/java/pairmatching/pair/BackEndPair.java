package pairmatching.pair;

import pairmatching.crew.Position;
import pairmatching.mission.Mission;

public class BackEndPair extends MissionPair {

    public BackEndPair(Mission mission) {
        super(mission, Position.BACKEND);
    }
}
