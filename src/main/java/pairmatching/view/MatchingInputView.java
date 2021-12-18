package pairmatching.view;

import pairmatching.utils.Validator;

public class MatchingInputView {
	public static String getInput() {
		String menuInput = "";
		while (menuInput.isEmpty()) {
			try {
				String userInput = camp.nextstep.edu.missionutils.Console.readLine();
				Validator.checkMatchInput(userInput);
				menuInput = userInput;
			}
			catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return menuInput;
	}
}
