package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;

import pairmatching.utils.Exception;
import pairmatching.utils.MenuValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

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
        if (!MenuValidator.validateInputMenu(menu, new ArrayList<>(
                Arrays.asList(MENU_PAIR_MATCHING, MENU_PAIR_LOOK_UP, MENU_PAIR_INIT, MENU_EXIT)))) {
            throw new IllegalArgumentException(Exception.MENU_EXCEPTION_MESSAGE);
        }
    }

    public static String processOfPairMatchingSelectMenu() {
        try {
            OutputView.printInformation();
            String courseLevelMission = InputView.inputCourseLevelMission();
            // selectPairMatchingMenu(courseLevelMission);
            return courseLevelMission;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfPairMatchingSelectMenu();

        }
        return null;
    }

    public static String processOfPairMatchingDuplicationMenu() {
        try {
            String courseLevelMission = InputView.askMatchingAgain();
            return courseLevelMission;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfPairMatchingDuplicationMenu();
        }
        return null;
    }

    public static String processOfPairMatchingReSelectMenu() {
        try {
            String courseLevelMission = InputView.inputCourseLevelMission();
            // selectPairMatchingMenu(courseLevelMission);
            return courseLevelMission;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            processOfPairMatchingReSelectMenu();
        }
        return null;
    }

    public static void selectPairMatchingMenu(String courseLevelMission) {
        validatePairMatchingMenu(courseLevelMission);
        String[] courseLevelMissions = splitCourseLevelMission(courseLevelMission, ",");
        String course = courseLevelMissions[0];

    }

    public static void validatePairMatchingMenu(String courseLevelMission) {
        if (!checkPairMatchingMenuSize(courseLevelMission)) {
            throw new IllegalArgumentException(Exception.COURSE_MISSION_LEVEL_EXCEPTION_MESSAGE);
        }
        if (!checkPairMatchingMenu(courseLevelMission)) {
            throw new IllegalArgumentException(Exception.COURSE_MISSION_LEVEL_EXCEPTION_MESSAGE);
        }
    }

    public static boolean checkPairMatchingMenuSize(String courseLevelMission) {
        String[] courseLevelMissions = splitCourseLevelMission(courseLevelMission, ",");
        return courseLevelMissions.length == 3;
    }

    public static boolean checkPairMatchingMenu(String courseLevelMission) {
        String[] courseLevelMissions = splitCourseLevelMission(courseLevelMission, ",");

        if (Course.getCourseList().contains(courseLevelMissions[0])
                && Level.getLevelList().contains(courseLevelMissions[1])
                && Mission.getMissionList().contains(courseLevelMissions[2])) {
            if (! Mission.isMatchMissionLevel(courseLevelMissions[1], courseLevelMissions[2])) {
                return false;
            }
            return true;
        }
        return false;
    }


    private static String[] splitCourseLevelMission(String inputInformation, String delimiter) {
        return inputInformation.split(delimiter);
    }
}