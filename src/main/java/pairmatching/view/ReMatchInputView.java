package pairmatching.view;

import pairmatching.utils.Validator;

public class ReMatchInputView {
	public static String getInput() {
		String reMatchInput = "";
		while (reMatchInput.isEmpty()) {
			try {
				String userInput = camp.nextstep.edu.missionutils.Console.readLine();
				Validator.checkReMatchInput(userInput);
				reMatchInput = userInput;
			}
			catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return reMatchInput;
	}
}
