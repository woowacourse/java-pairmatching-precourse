package pairmatching.view;

import pairmatching.infomation.Course;
import pairmatching.infomation.LevelRepository;
import pairmatching.infomation.Mission;
import pairmatching.infomation.MissionRepository;

import java.util.ArrayList;

public class OutputView {
    private static final String COURSE = "과정: ";
    private static final String DELIMITER = " | ";
    private static final String COLON = ": ";
    private static final String MISSION = "미션:";
    private static final String LEVEL = "- 레벨";

    public void outputInformation() {
        printDecoration();
        printCourse();
        printMission();
        printDecoration();
    }

    private void printDecoration() {
        System.out.println("#############################################");
    }

    private void printCourse() {
        ArrayList<String> courses = Course.getCourses();
        System.out.print(COURSE);
        for (int index = 0; index < courses.size(); index++) {
            if (index == courses.size() - 1) {
                System.out.print(courses.get(index));
                return;
            }
            System.out.print(courses.get(index) + DELIMITER);
        }
    }

    private void printMission() {
        System.out.println("");
        System.out.println(MISSION);
        ArrayList<Mission> missions = MissionRepository.getMissions();
        ArrayList<Integer> levels = LevelRepository.getLevels();
        for (Integer level : levels) {
            printMissionByLevel(level, missions);
        }
    }

    private void printMissionByLevel(int level, ArrayList<Mission> missions) {
        System.out.print(LEVEL + level + COLON);
        String levelNames = "";
        for (Mission mission : missions) {
            if (mission.getLevel() == level) {
                levelNames += mission.getName() + DELIMITER;
            }
        }
        if (levelNames.length() > 2) {
            levelNames = levelNames.substring(0, levelNames.length()-2);
        }
        System.out.println(levelNames);
    }
}
