package pairmatching;

import pairmatching.crew.LoadFile;
import pairmatching.crew.PairMatching;
import pairmatching.util.CategoryDivider;
import pairmatching.util.CourseMatch;
import pairmatching.util.LevelMatch;
import pairmatching.view.Constant;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class Program {
    public static boolean again = true;
    public static List<String> category;
    public static List<List<String>> pairCrew;

    public static Course course;
    public static Level level;
    public static String mission;

    public static boolean on() {
        return again;
    }

    public static void play() {
        String choice = InputView.askMain();
        if (choice.equals(Constant.ONE)) {
            choiceOne();
        }
        if (choice.equals(Constant.TWO)) {

        }
        if (choice.equals(Constant.THREE)) {

        }
        if (choice.equals(Constant.Q)) {
            again = false;
        }
    }

    public static void choiceOne() {
        choiceCategory();
        pairMatch();
    }

    public static void choiceCategory() {
        OutputView.printMenu();
        String answer = InputView.askCategory();
        category = CategoryDivider.divideCategory(answer);
        course = CourseMatch.getCourse(category.get(0));
        level = LevelMatch.getLevel(category.get(1));
        mission = category.get(2);
    }

    public static void pairMatch() {
        while (true) {
            try {
                PairMatching.pairMatch(course, level, mission);
                pairCrew = PairMatching.getPairCrew();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        OutputView.printPairMatching(pairCrew);
    }
}
