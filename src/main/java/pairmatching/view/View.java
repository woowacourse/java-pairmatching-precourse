package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.Arrays;
import java.util.stream.Collectors;

public class View {

    private static final String PRETTY_BORDER = "#############################################";
    private static final String MENU_DELIMITER = " | ";

    public static Menu getMenu() {
        try {
            printMenu();
            System.out.println();
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
