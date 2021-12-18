package pairmatching.pair;

import pairmatching.crew.Position;
import pairmatching.mission.Mission;

public class FrontEdnPair extends MissionPair {

    public FrontEdnPair(Mission mission) {
        super(mission, Position.FRONTEND);
    }
}
