package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validation.AnswerValidation;
import pairmatching.validation.CategoryValidation;
import pairmatching.validation.ChoiceValidation;

public class InputView {
    public static String askMain() {
        while (true) {
            try {
                OutputView.printMain();
                String input = Console.readLine();
                ChoiceValidation.validateChoice(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String askCategory() {
        while (true) {
            try {
                System.out.println(Constant.ASK_PAIR);
                System.out.println(Constant.EX);
                String input = Console.readLine();
                CategoryValidation.validateCategory(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String askRePairMatching() {
        while (true) {
            try {
                System.out.println(Constant.RE_PAIR_MATCHING);
                System.out.println(Constant.Y_N);
                String input = Console.readLine();
                AnswerValidation.validationAnswer(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
