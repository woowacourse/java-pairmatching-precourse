package pairmatching.view;

import pairmatching.utils.Validator;

public class MenuInputView {
	public static String getInput() {
		String menuInput = "";
		while (menuInput.isEmpty()) {
			try {
				String userInput = camp.nextstep.edu.missionutils.Console.readLine();
				Validator.checkMenuInput(userInput);
				menuInput = userInput;
			}
			catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return menuInput;
	}
}
