package pairmatching.view;

import pairmatching.model.*;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String DIVIDER = "#############################################";

    public void printInformation() {
        System.out.println(DIVIDER);
        printCourse();
        printMissions();
        System.out.println(DIVIDER);
    }

    private void printCourse() {
        System.out.print("과정: ");
        List<String> stringList = new ArrayList<>();
        for (Course course : Course.values()) {
            stringList.add(course.getName());
        }
        System.out.println(String.join(" | ", stringList));

    }

    private void printMissions() {
        System.out.println("미션: ");
        for (Level level : Level.values()) {
            System.out.print("- " + level.getName() + ": ");
            printMission(level.getMissions());
        }
    }

    private void printMission(ArrayList<Mission> missions) {
        ArrayList<String> stringList = new ArrayList<>();
        for (Mission mission : missions) {
            stringList.add(mission.getName());
        }
        System.out.println(String.join(" | ", stringList));
    }

    public void printPairList(Course course, Mission mission) {
        PairList pairList = mission.getPairList(course);
        System.out.println(pairList.getPairListLength());
        for (Pair pair : pairList.getPairList()) {
            printPair(pair);
        }
    }

    public void printPair(Pair pair) {
        System.out.println(String.join(":", pair.getPair()));
    }
}
