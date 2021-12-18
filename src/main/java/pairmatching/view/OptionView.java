package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Message;
import pairmatching.model.Option;

public class OptionView {

	public String getInput() {
		System.out.println(Message.INPUT_OPTION);
		try {
			String input = Console.readLine();
			System.out.println();
			Option.checkInput(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
			return getInput();
		}
	}
}
