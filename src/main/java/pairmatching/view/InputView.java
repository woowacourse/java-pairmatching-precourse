package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Menu;
import pairmatching.util.Constants;

public class InputView {
	public static String inputMenu(Menu menu) {
		System.out.println(Constants.INPUT_MESSAGE_SELECT_MENU);
		System.out.println(menu);
		return Console.readLine();
	}

	public static String inputProcess() {
		System.out.println(Constants.INPUT_MESSAGE_PROCESS);
		return Console.readLine();
	}
}
