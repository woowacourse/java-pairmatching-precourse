package pairmatching.view;

import org.assertj.core.util.Arrays;
import pairmatching.Course;
import pairmatching.Level;

import java.util.List;

public class OutputView {
    public static void printMain() {
        System.out.println(Constant.ASK_CHOICE);
        System.out.println(Constant.CHOICE_ONE);
        System.out.println(Constant.CHOICE_TWO);
        System.out.println(Constant.CHOICE_THREE);
        System.out.println(Constant.CHOICE_FOUR);
    }

    public static void printMenu() {
        System.out.println(Constant.DELIMITER);
        printCourse();
        printMission();
        System.out.println(Constant.DELIMITER);
    }

    public static void printPairMatching() {
        System.out.println(Constant.RESULT_PAIR_MATCHING);
    }

    public static void reset() {
        System.out.println(Constant.RESET);
    }

    public static void printCourse() {
        System.out.print(Constant.COURSE);
        System.out.println(Course.BACKEND.getName() + Constant.OR +Course.FRONTEND.getName());
    }

    public static void printMission() {
        System.out.println(Constant.MISSION);
        for (Level level : Level.values()) {
            System.out.println(Constant.TAP + level.getName() + Constant.COLON + level.getMissions());
        }
    }
}
