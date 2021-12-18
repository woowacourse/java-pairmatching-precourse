package pairmatching.domain.mission;

import pairmatching.domain.Level;

import java.util.HashSet;
import java.util.Set;

public class MissionSet {
    private Set<Mission> missions;

    private MissionSet() {
        this.missions = new HashSet<>();
    }

    public static MissionSet getInstance() {
        return new MissionSet();
    }

    public void addMission(Mission mission) {
        missions.add(mission);
    }

    public boolean hasMissionInSameLevel(Level level, MissionName missionName) {
        return missions.stream().anyMatch((mission) -> mission.isSameMission(level, missionName));
    }
}
