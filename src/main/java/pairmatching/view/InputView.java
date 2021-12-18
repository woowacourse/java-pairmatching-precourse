package pairmatching.view;

import static pairmatching.constants.InputMsg.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String selectFunction() {
		System.out.println(SELECT_FUNC);
		return Console.readLine();
	}
}
