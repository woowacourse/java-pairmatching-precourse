package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.pair.PairTag;

import java.util.Arrays;
import java.util.stream.Collectors;

public class View {

    private static final String PRETTY_BORDER = "#############################################";
    private static final String MENU_DELIMITER = " | ";
    public static final String USER_REQUEST_DELIMITER = ",";
    private static final int COURSE_INDEX = 0;
    private static final int MISSION_INDEX = 1;
    private static final int MISSION_NAME_INDEX = 2;

    public static Menu getMenu() {
        try {
            printMenu();
            return Menu.of(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenu();
        }
    }

    private static void printMenu() {
        System.out.println("기능을 선택하세요");
        Arrays.stream(Menu.values())
                .forEach(menu -> System.out.println(
                        menu.getSymbol() + ". " + menu.getName()
                ));
    }

    public static void printBoard() {
        System.out.println(PRETTY_BORDER);
        printCourses();
        printMissions();

        System.out.println(PRETTY_BORDER);
    }

    public static PairTag getPairTag() {
        while (true) {
            try {
                System.out.println("과정, 레벨, 미션을 선택하세요");
                String[] requests = getUserRequests();
                return makePairTagFromRequests(requests);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return getPairTag();
            }
        }
    }

    private static String[] getUserRequests() {
        String[] requests = Console.readLine().split(USER_REQUEST_DELIMITER);
        for (int i = 0; i < requests.length; i++) {
            requests[i] = requests[i].trim();
        }
        return requests;
    }

    private static PairTag makePairTagFromRequests(String[] requests) {
        Course course = getCourse(requests[COURSE_INDEX]);
        Level level = getLevel(requests[MISSION_INDEX]);
        String missionName = requests[MISSION_NAME_INDEX];
        level.checkHasMission(missionName);
        return new PairTag(course, level, missionName);
    }

    private static Level getLevel(String name) {
        return Level.of(name);
    }

    private static Course getCourse(String name) {
        return Course.of(name);
    }

    private static void printCourses() {
        String courses = Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining(MENU_DELIMITER));
        System.out.println("과정: " + courses);
    }

    private static void printMissions() {
        System.out.println("미션:");
        for (Level level : Level.values()) {
            System.out.println("\t - " + level.getName() + ": " +
                    level.getMissionNames().stream()
                            .collect(Collectors.joining(MENU_DELIMITER)));
        }
    }
}
