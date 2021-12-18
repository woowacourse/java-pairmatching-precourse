package pairmatching.view;

import java.util.ArrayList;

import pairmatching.domain.Pair;
import pairmatching.domain.PairRepository;
import pairmatching.init.Course;
import pairmatching.init.LevelRepository;
import pairmatching.init.Mission;
import pairmatching.init.MissionRepository;

public class OutputView {
    private static final String COURSE = "과정: ";
    private static final String DELIMITER = " | ";
    private static final String COLON = ": ";
    private static final String MISSION = "미션:";
    private static final String LEVEL = "- 레벨";

    public void outputInformation() {
        divisionLine();
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

    public void outputMatching(String course, String level, String mission) {
        divisionLine();
        System.out.println("페어 매칭 결과입니다.");
        ArrayList<Pair> pairInformation = PairRepository.getPairInformation();
        for (Pair pair : pairInformation) {
            if (pair.getCourse().equals(course) && pair.getLevel().equals(level) && pair.getMission().equals(mission)) {
                printPair(pair);
            }
        }
        divisionLine();
    }

    private void divisionLine() {
        System.out.println();
    }

    private void printPair(Pair pair) {
        ArrayList<String> crews = pair.getCrews();;
        for (int idx = 0; idx < crews.size(); idx++) {
            if (idx == crews.size() - 1) {
                System.out.print(crews.get(idx));
                System.out.println();
                return;
            }
            System.out.print(crews.get(idx) + " : ");
        }
    }
}
