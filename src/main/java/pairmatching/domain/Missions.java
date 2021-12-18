package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.exception.MissionNameDuplicateException;
import pairmatching.exception.MissionNotFoundException;

public class Missions {

    private final List<Mission> missions;

    public Missions(List<Mission> missions) {
        this.missions = missions;
    }

    public static Missions init() {
        return new Missions(new ArrayList<>());
    }

    public void addWithMissionName(String name) {
        addMission(Mission.createEmptyMission(name, Course.BACKEND));
        addMission(Mission.createEmptyMission(name, Course.FRONTEND));
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

    public boolean isAlreadyMatchCrew(List<Match> matches) {
        return missions.stream()
            .anyMatch(mission -> matches.stream().anyMatch(mission::containAlreadyMatchCrew));
    }

    public boolean isMatched(Mission mission) {
        return missions.stream()
            .filter(mission1 -> mission1.isEqualsMission(mission))
            .findFirst()
            .map(Mission::isMatched)
            .orElse(false);
    }

    public Mission mission(Mission mission) {
        return missions.stream()
            .filter(mission1 -> mission1.isEqualsMission(mission))
            .findFirst()
            .orElseThrow(MissionNotFoundException::new);
    }
}
