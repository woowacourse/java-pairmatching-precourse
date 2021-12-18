package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.model.Level;
import pairmatching.model.LevelAndMission;
import pairmatching.model.Mission;
import pairmatching.repository.LevelAndMissionRepository;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GetFile.getBackendCrew();
        GetFile.getFrontendCrew();
        addMissionsInLevel();
        MainController mainController = MainController.getInstance();
        mainController.run();
    }

    private static void addMissionsInLevel() {
        List<Mission> levelOne = new ArrayList<>();
        List<Mission> levelTwo = new ArrayList<>();
        List<Mission> levelThree = new ArrayList<>();
        List<Mission> levelFour = new ArrayList<>();
        List<Mission> levelFive = new ArrayList<>();

        levelOne.add(Mission.MISSION_RACE);
        levelOne.add(Mission.MISSION_LOTTO);
        levelOne.add(Mission.MISSION_BASEBALL);
        LevelAndMissionRepository.addLevelAndMission(new LevelAndMission(Level.LEVEL1, levelOne));

        levelTwo.add(Mission.MISSION_BASKET);
        levelTwo.add(Mission.MISSION_PAYMENT);
        levelTwo.add(Mission.MISSION_SUBWAY);
        LevelAndMissionRepository.addLevelAndMission(new LevelAndMission(Level.LEVEL2, levelTwo));
        LevelAndMissionRepository.addLevelAndMission(new LevelAndMission(Level.LEVEL3, levelThree));

        levelFour.add(Mission.MISSION_PERFORMANCE);
        levelFour.add(Mission.MISSION_DEPLOY);
        LevelAndMissionRepository.addLevelAndMission(new LevelAndMission(Level.LEVEL4, levelFour));
        LevelAndMissionRepository.addLevelAndMission(new LevelAndMission(Level.LEVEL5, levelFive));


    }
}
