package pairmatching.view;

import static constants.PairMatchingConstants.*;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.FeatureInputValidator;

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
}
