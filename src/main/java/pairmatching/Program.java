package pairmatching;

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

    public static boolean on() {
        return again;
    }

    public static void choiceMain() {
        String choice = InputView.askMain();
        if (choice.equals(Constant.ONE)) {

        }
        if (choice.equals(Constant.TWO)) {

        }
        if (choice.equals(Constant.THREE)) {

        }
        if (choice.equals(Constant.Q)) {
            again = false;
        }
    }

    public static void choiceCategory() {
        OutputView.printMenu();
        String answer = InputView.askCategory();
        category = CategoryDivider.divideCategory(answer);
        Course course = CourseMatch.getCourse(category.get(0));
        Level level = LevelMatch.getLevel(category.get(1));
    }
}
