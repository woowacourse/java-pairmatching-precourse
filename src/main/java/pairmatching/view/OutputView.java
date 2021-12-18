package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Level;

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

    private void printMission(ArrayList<String> missions) {
        System.out.println(String.join(" | ", missions));
    }
}
