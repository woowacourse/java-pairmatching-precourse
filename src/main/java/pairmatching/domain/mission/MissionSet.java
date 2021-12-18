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

    public boolean findDuplicated(Mission target) {
        return missions.stream().anyMatch((mission) -> mission.hasSamePair(target));
    }

    public void removeMission(MissionName missionName) {
        Mission mission = missions.stream()
                .filter((target) -> target.isName(missionName.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 없는 미션"));

        missions.remove(mission);
    }

    public String getMissionResult(MissionName name) {
        Mission mission = missions.stream()
                .filter((target) -> target.isName(name.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 없는 미션"));

        return mission.toString();
    }

    public boolean hasMissionByName(MissionName input) {
        return missions.stream().anyMatch((mission) -> mission.isName(input.getName()));
    }

    public void clear() {
        missions.clear();
    }
}
