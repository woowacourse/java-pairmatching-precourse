package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.Constant;

public class InputView {
	
	//기능을 선택하세요.
	public static String select_fuction() {
		return Console.readLine().trim();
	}
	
	//과정, 레벨, 미션을 선택하세요.
	public static String select_course() {
		return Console.readLine().trim();
	}
	
	public static String askAnswer() {
		return Console.readLine();
	}
}
