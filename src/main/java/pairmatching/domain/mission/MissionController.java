package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.HashMap;

import pairmatching.domain.course.Course;
import pairmatching.domain.crew.BackEndCrewRepository;
import pairmatching.domain.crew.FrontEndCrewRepository;
import pairmatching.domain.level.Level;
import pairmatching.domain.matcher.PairHistory;

public class MissionController {
    private final HashMap<String, ArrayList<Mission>> missionTable = new HashMap<>();
    private final HashMap<String, PairHistory> backEndPairHistory = new HashMap<>();
    private final HashMap<String, PairHistory> frontEndPairHistory = new HashMap<>();


    public void initializeMissions() {
        missionTable.clear();
        for (Level level : Level.values()) {
            missionTable.put(level.getName(), new ArrayList<Mission>());
            backEndPairHistory.put(level.getName(),
                new PairHistory(BackEndCrewRepository.getCrews()));
            frontEndPairHistory.put(level.getName(),
                new PairHistory(FrontEndCrewRepository.getCrews()));
        }

        for (BaseMission baseMission : BaseMission.values()) {
            addMission((baseMission));
        }
    }

    private void addMission(BaseMission mission) {
        missionTable.get(mission.getMission().getName()).add(mission.getMission());
    }

    public void startMatch(Course course, Level level, String MissionName) {

    }

    private void checkMissonAndLevelMatch(String MissionName, String LevelName) {

    }
}
