package pairmatching.view;

import java.util.List;
import java.util.Map;
import pairmatching.domain.Level;

public class OutputView {

    private static final String COURSE = "과정: ";
    private static final String MISSION = "미션:";
    private static final String MISSION_LEVEL = "  - %s: %s";

    private static final String PRINT_DELEMITER = "############################################";
    private static final String DELEMITER = " | ";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printCurrentBoard(List<String> courses, Map<Level, List<String>> missions) {
        System.out.println(PRINT_DELEMITER);
        System.out.print(COURSE);
        System.out.println(printCourses(courses));
        System.out.println(MISSION);
        for (Level level : missions.keySet()) {
            System.out.printf(MISSION_LEVEL, level.getName(), printMissions(missions.get(level)));
            System.out.println();
        }
        System.out.println(PRINT_DELEMITER);
    }

    private static String printCourses(List<String> courses) {
        return String.join(DELEMITER, courses);
    }

    private static String printMissions(List<String> missions) {
        return String.join(DELEMITER, missions);
    }
}
