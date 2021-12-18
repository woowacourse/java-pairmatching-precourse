package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.exception.MissionNameDuplicateException;

public class Missions {

    private final List<Mission> missions;

    public Missions(List<Mission> missions) {
        this.missions = missions;
    }

    public static Missions init() {
        return new Missions(new ArrayList<>());
    }

    public void addMission(Mission mission) {
        checkSameMissionName(mission);
        missions.add(mission);
    }

    private void checkSameMissionName(Mission mission) {
        if (isContainMission(mission)) {
            throw new MissionNameDuplicateException();
        }
    }

    public boolean isContainMission(Mission mission) {
        return missions.stream().anyMatch(mission1 -> mission1.isEqualsMission(mission));
    }

    public boolean isAlreadyMatch(Mission mission) {
        return missions.stream()
            .filter(mission1 -> mission1.isEqualsMission(mission))
            .findFirst()
            .map(Mission::isAlreayMatch)
            .orElse(false);
    }
}
