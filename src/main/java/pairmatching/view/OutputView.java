package pairmatching.view;

import pairmatching.domain.pairMatcher.enums.Course;
import pairmatching.domain.pairMatcher.enums.Level;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void selectMission() {
        printHashLine();
        printCourse();
        printMissions();
        printHashLine();
    }

    private static void printHashLine() {
        System.out.println("#############################################");
    }

    private static void printCourse() {
        System.out.print("과정: ");
        List<String> courseList = new ArrayList<String>();
        for (Course course : Course.values()) {
            courseList.add(course.getName());
        }
        System.out.println(String.join(" | ", courseList));
    }

    private static void printMissions() {
        System.out.println("미션: ");
        for (Level level : Level.values()) {
            System.out.print("  - " + level.getName() + ": ");
            System.out.println(String.join(" | ", level.getMissions()));
        }
    }

}
