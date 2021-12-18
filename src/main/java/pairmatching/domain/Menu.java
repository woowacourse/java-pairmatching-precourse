package pairmatching.domain;

import pairmatching.utils.MenuValidator;
import pairmatching.view.InputView;
import pairmatching.utils.Exception;
import pairmatching.view.OutputView;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Level;
import pairmatching.domain.Course;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    public static final String MENU_PAIR_MATCHING = "1";
    public static final String MENU_PAIR_LOOK_UP = "2";
    public static final String MENU_PAIR_INIT = "3";
    public static final String MENU_EXIT = "Q";

    public static String processOfSelectMenu() {
        try {
            String menu = InputView.selectMenu();
            selectMenu(menu);
            return menu;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfSelectMenu();
        }
        return MENU_EXIT;
    }

    public static void selectMenu(String menu) {
        validateSelectMenu(menu);
    }

    public static void validateSelectMenu(String menu) {
        if (!MenuValidator.validateInputMenu(menu, new ArrayList<>(
                Arrays.asList(MENU_PAIR_MATCHING, MENU_PAIR_LOOK_UP, MENU_PAIR_INIT, MENU_EXIT)))) {
            throw new IllegalArgumentException(Exception.MENU_EXCEPTION_MESSAGE);
        }
    }

    public static String processOfPairMatchingSelectMenu() {
        try {
//            OutputView.printInformation(Course.getCourseList(), Level.getLevelList(), );
            String courseLevelMission = InputView.inputCourseLevelMission();
            return courseLevelMission;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfPairMatchingSelectMenu();
        }
        return null;
    }

}
