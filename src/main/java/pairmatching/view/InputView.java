package pairmatching.view;

import static constants.PairMatchingConstants.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.ExistingPairValidator;
import pairmatching.validator.FeatureInputValidator;
import pairmatching.validator.PairBackgroundInfoValidator;

public class InputView {
	public static String getFeature() {
		while (true) {
			System.out.println(FEATURE_MENU_MESSAGE);
			System.out.println(FEATURE_MENU_LIST);
			String userInput = Console.readLine();
			try {
				FeatureInputValidator.checkFeatureInput(userInput);
				return userInput;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	public static List<String> getPairBackgroundInfo() {
		while (true) {
			OutputView.printMenu();
			System.out.println(INPUT_MENU_MESSAGE);
			System.out.println(INPUT_MENU_EXAMPLE);
			String userInput = Console.readLine();
			try {
				return PairBackgroundInfoValidator.checkInput(userInput);
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}

	public static String getTryMore() {
		while (true) {
			System.out.println(DUPLICATE_MESSAGE);
			System.out.println(DUPLICATE_OPTIONS);
			String userInput = Console.readLine();
			try {
				ExistingPairValidator.checkInput(userInput);
				return userInput;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
	}
}
