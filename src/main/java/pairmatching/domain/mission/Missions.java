package pairmatching.domain.mission;

import pairmatching.domain.Level;
import pairmatching.domain.mission.Mission;

import java.util.ArrayList;
import java.util.List;

public class Missions {
    private List<Mission> missions = new ArrayList<>();

    public void add(Mission mission) {
        missions.add(mission);
    }

    public boolean hasMission(Level level, String name) {
        for (Mission mission : missions) {
            if (mission.equal(level, name)) {
                return true;
            }
        }
        return false;
    }
}
